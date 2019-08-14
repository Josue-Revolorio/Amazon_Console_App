package com.Jcode.AmazonViewer;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.Jcode.AmazonViewer.Model.Book;
import com.Jcode.AmazonViewer.Model.Chapter;
import com.Jcode.AmazonViewer.Model.Magazine;
import com.Jcode.AmazonViewer.Model.Movie;
import com.Jcode.AmazonViewer.Model.Serie;
import com.Jcode.makereport.Report;

public class Amazon {
	private static Scanner in;
	
	public static void main(String[] args) {
		
		showMenu();

	}
	
	public static void showMenu() {
		in = new Scanner(System.in);
		int opc;
        do {
            System.out.println("Welcome Amazon Viewer.");
            System.out.println("[1] Movies");
            System.out.println("[2] Series");
            System.out.println("[3] Books");
            System.out.println("[4] Magazines");
            System.out.println("[5] Report");
            System.out.println("[6] Report Today");
            System.out.println("[0] Exit");
            System.out.print("Enter the option: ");
            opc = in.nextInt();
            switch (opc){
                case 1: showMovies(); break;
                case 2: showSeries(); break;
                case 3: showBooks(); break;
                case 4: showMagazines(); break;
                case 5: makeReport(); break;
                case 6: makeReport( new Date() ); break;    // Date date = new Date();
            }
        }while (opc!=0);
		
		
	}
	
	//-------------------------------Menu the movies ---------------------------------------------
    static ArrayList<Movie> movies = new ArrayList<Movie>();
	public static void showMovies() {
		movies = Movie.makeMoviesList();
		
		// Variables 
		in = new Scanner(System.in);
		int opc;
		
        do {
        	//Show movie list 
            System.out.println("\n"+":: MOVIES ::"+"\n");
            
            
            //auto incrementa 
            AtomicInteger atomicInteger = new AtomicInteger(1);
            movies.forEach(m -> System.out.println(atomicInteger.getAndIncrement()+". " + m.getTitle()+ " visto " + m.isViewed()));
            
            
            /*for (int i = 0; i < movies.size(); i++) {
                System.out.println(i+1 + ". " + movies.get(i).getTitle()+ " visto " + movies.get(i).isViewed());
            }*/
            
            System.out.println("0. Return the Menu");
            System.out.print("Enter the option: ");
            opc = in.nextInt();
            System.out.println(" ");

            
            if(opc >= 1) {
                Movie movieSelected = movies.get(opc - 1);
                movieSelected.view();
                
            }
        }while(opc!=0);

	}
	
	//-------------------------------Menu the Series y Chapters ---------------------------------------
	static ArrayList<Serie> series = Serie.makeSeriesList();
	public static void showSeries() {
		//Variables
		in = new Scanner(System.in);
		int opc;
		
		do {
			//Show series list 
            System.out.println("\n"+":: SERIES ::"+"\n");
            for (int i = 0; i < series.size(); i++) {
                System.out.println(i+1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
            }
            System.out.println("0. Return the Menu");
            System.out.print("Enter the option: ");
            opc = in.nextInt();
            System.out.println(" ");
          
           // Requesting the chapters of the method.
            if(opc>=1) {
                showChapters(series.get(opc - 1).getChapters());
            }
            
        }while(opc!=0);
    }
		
	
	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		//variables
		in = new Scanner(System.in);
        int opc;
        do {
        	//Show chapter list 
            System.out.println("\n"+":: CHAPTER ::"+"\n");
            for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { //1. Chapter 1
                System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: " + chaptersOfSerieSelected.get(i).isViewed());
            }
            System.out.println("0. Return the Menu");
            System.out.print("Enter the option: ");
            opc = in.nextInt();
            System.out.println(" ");

            
            if(opc>=1){
                Chapter chapterSelected = chaptersOfSerieSelected.get(opc-1);
                chapterSelected.view();
            }

        }while(opc!=0);
		
	}
	
	//-------------------------------Menu the Books ---------------------------------------------
	static ArrayList<Book> books= Book.makeBookList();
	public static void showBooks() {
		//variables
		in = new Scanner(System.in);
        int opc;
        do {
            //Show Books list
            System.out.println("\n"+":: BOOKS ::"+"\n");

            for(int i=0; i<books.size(); i++){
                System.out.println(i+1 +". "+books.get(i).getTitle()+ " Leido " + books.get(i).isReaded());
            }
            System.out.println("0. Return the Menu");
            System.out.print("Enter the option: ");
            opc = in.nextInt();
            System.out.println(" ");

            if(opc>=1){
                Book bookSelected = books.get(opc-1);
                bookSelected.view();
            }

        }while(opc!=0);
		
	}
	
	//-------------------------------Menu the Magazines ---------------------------------------------
	static ArrayList<Magazine> magazines = Magazine.makeMagazineList();
	public static void showMagazines() {
	    //Variables
		in = new Scanner(System.in);
        int opc;
        do {
        	//Show Magazines list
            System.out.println("\n"+":: MAGAZINES ::"+"\n");
            for (int i = 0; i < magazines.size(); i++) {
                System.out.println(i+1 + ". " + magazines.get(i).getTitle());
            }

            System.out.println("0. Return the Menu");
            System.out.print("Enter the option: ");
            opc = in.nextInt();
            System.out.println(" ");
           
            if(opc>=1){
            	//information about the Magazine
                Magazine magazineSelected = magazines.get(opc -1);
                System.out.println(magazineSelected);
                System.out.println(" Author: "+ magazineSelected.getAuthors());
            }
        }while(opc!=0);
		
	}
	
	//-------------------------------Method the reports ---------------------------------------------
	
   public  static void makeReport(){
    	
    	//Object
    	Report report = new Report();
    	
    	//set
    	report.setNameFile("reporte");
    	report.setExtension("txt");
    	
        // set data 
    	report.setTitle(":: Vistos :: \n");
    	StringBuilder contentReport = new StringBuilder();
    	
    	
    	//Stream y Filter
    	movies.stream().filter(m -> m.getIsviewed())
    	.forEach(m -> contentReport.append(m.toString()+"\n"));
    	
    	
       
    	/*for(Movie movie: movies) {
    		if(movie.getIsviewed()) {
    			contentReport += movie.toString()+"\n";
    		}
    	}*/
    	
    	//Predicate<Serie>predicate = s -> s.getIsviewed();
    	//Consumer<Serie> serieEachConsumer = s -> contentReport.append(s.toString() + "\n");
    	
    	Consumer<Serie> serieEach = s -> {
    		ArrayList<Chapter> chapters = s.getChapters();
    		chapters.stream().filter(c -> c.getIsviewed()).forEach(c -> contentReport.append(c.toString()+"\n"));
    	};
    	
    	series.stream().forEach(serieEach);
    	
    	/*for (Serie serie : series ) {
    		ArrayList<Chapter> chapters = serie.getChapters();
    		for (Chapter chapter : chapters) {
				if (chapter.getIsviewed()) {
					contentReport.append(chapter.toString() + "\n");
					
				}
			}	
		}*/
    	
    	books.stream().filter(b -> b.getIsReaded())
    	.forEach(b -> contentReport.append(b.toString()+"\n"));
    	
    	/*for (Book book : books) {
			if (book.getIsReaded()) {
				contentReport.append(book.toString() + "\n");
				
			}
		}*/

    	report.setContent(contentReport.toString());
    	report.makeReport();
    	System.out.println("\n"+"Reporte Generado"+"\n");
    }
   
    
    public static void makeReport(Date date) {  // Date  = it's a type of data   //date = is the variable
        // format of date 
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	String dateString = df.format(date);
    	Report report = new Report();
    	
    	report.setNameFile("report"+ dateString);
    	report.setExtension("txt");
        // set data 
    	report.setTitle(":: Vistos :: \n");
    	//String contentReport ="";
    	SimpleDateFormat dfNameDays = new SimpleDateFormat("E, dd MMM Y");
		dateString = dfNameDays.format(date);
		String contentReport = "Date: " + dateString + "\n\n";
    	
   
    	
    	for(Movie movie: movies) {
    		if(movie.getIsviewed()) {
    			contentReport += movie.toString()+"\n";
    		}
    	}
    
    	for (Serie serie : series) {
			ArrayList<Chapter> chapters = serie.getChapters();
			for (Chapter chapter : chapters) {
				if (chapter.getIsviewed()) {
					contentReport += chapter.toString() + "\n";
					
				}
			}
		}
		
		for (Book book : books) {
			if (book.getIsReaded()) {
				contentReport += book.toString() + "\n";
				
			}
		}
    	
    	report.setContent(contentReport);
    	report.makeReport();
    	System.out.println("\n"+"Reporte Generado"+"\n");
    	
    }

}