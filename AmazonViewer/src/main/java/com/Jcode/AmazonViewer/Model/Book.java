package com.Jcode.AmazonViewer.Model;
import com.Jcode.AmazonViewer.util.AmazonUtil;
import java.util.ArrayList;
import java.util.Date;


public class Book  extends Publication implements Ivisualizable {
	
	 // Attributes
	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;
	private ArrayList<Page> pages;
	
	// builder method
	public Book(String title, Date edititionDate, String editorial, String[] authors, ArrayList<Page> pages) {
		super(title, edititionDate, editorial);
		setAuthors(authors);
		this.pages = pages;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isReaded() {
		return readed;
	}
	
	public boolean getIsReaded() {
		return readed;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	public int getTimeReaded() {
		return timeReaded;
	}

	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}
	
	
	public ArrayList<Page> getPages() {
		return pages;
	}

	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}

	// Overwriting toString
	@Override
    public String toString() {
        String detailBook = "\n :: BOOK ::"  +
                            "\n Title: "     + getTitle() +
                            "\n Editorial: " + getEditorial() +
                            "\n Edition Date: " + getEdititionDate() +
                            "\n Authors: ";
        // getAuthors
        for (int i = 0; i < getAuthors().length; i++) {
            detailBook += "\t" + getAuthors()[i];
        }
        return  detailBook;
    }
	
	// overwriting the Method of Interface
    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    //Subtract the start time of the end time
    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if( dateF.getTime() > dateI.getTime()){
            setTimeReaded((int)(dateF.getTime() - dateI.getTime()));
        }else{
            setTimeReaded(0);
        }
    }
    
    public void view() {
    	setReaded(true);

        //start watching Book
        Date dateI = startToSee(new Date());
        
        int i=0;
        do {
        	
			System.out.println("::::::::::::::::::::::::::::::::::::::");
			System.out.println("Page" + getPages().get(i).getNumber());
			System.out.println(getPages().get(i).getContent());
			System.out.println(":::::::::::::::::::::::::::::::::::::::");
			
			if(i != 0) {
				System.out.println("1. Return page");
			}
			
			System.out.println("2. Next page");
			System.out.println("0. Close Book");
			System.out.println();
			
			int opc = AmazonUtil.validateUserResponseMenu(0, 2);
			
			if(opc==2) {
				i++;
			}
			else if (opc==1) {
				i--;
			}
			else if (opc == 0) {
				break;
			}
			
			
		} while ( i < getPages().size());

        //end of reading of the book
        stopToSee(dateI , new Date());
        
        //information about the Book
        System.out.println();
        System.out.println("Leíste: " + toString());
        System.out.println("Por: " + getTimeReaded()+ " milisegundos");
    	
    }
    

    // Method generates a list of Book
    public static ArrayList<Book> makeBookList() {
       ArrayList<Book> books = new ArrayList<Book>();
       //String[] authors = new String[3];
       String[] authors = {"Josue","Pablo","Marcos"};
       
       ArrayList<Page> pages = new ArrayList<>();
       int paginas = 0;
       
       for (int i = 0; i < 3; i++) {
    	   paginas = i+1;
    	   
    	   //class anidada 
    	   pages.add(new Book.Page(paginas, "The content of the page" + paginas));
    	   
       }
       
       
       for (int i = 1; i<=5; i++ ){
           books.add(new Book("Book " + i , new Date(),"editorial " + i, authors, pages));
       }
       return books;
    }
    
    // shows the content per page
    public static class Page{
    	private int id;
    	private int number;
    	private String content;
    	
    	
		public Page(int number, String content) {
			super();
			this.number = number;
			this.content = content;
		}
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
    	
    	
    }
    
	
}
