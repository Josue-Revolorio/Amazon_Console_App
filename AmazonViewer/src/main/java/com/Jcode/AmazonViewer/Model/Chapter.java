package com.Jcode.AmazonViewer.Model;
import java.util.ArrayList;
public class Chapter extends Movie {
	
	// Attributes
	private int id; 
	private int sessionNumber;
	private Serie serie;
	
	// builder method
	public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber, Serie serie) {
		super(title, genre, creator, duration, year);
		this.sessionNumber = sessionNumber;
		this.setSerie(serie);
	}

	// Getters y Setters
	
	//overwriting the id
    @Override
    public int getId() {
        return this.id;
    }
	
	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}
	

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	// Overwriting toString
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: SERIE ::" + 
				"\n Title: "     + getSerie().getTitle() +
				"\n :: CHAPTER ::" + 
				"\n Title: "       + getTitle() +
				"\n Year: "        + getYear() + 
				"\n Creator: "     + getCreator() +
				"\n Duration: "    + getDuration();
	}

	
	// Method generates a list of chapters
    public static ArrayList<Chapter> makeChaptersList(Serie serie) {
        ArrayList<Chapter> chapters = new ArrayList<Chapter>();

        for (int i = 1; i <= 5; i++) {
            chapters.add(new Chapter("Capituo "+i, "genero "+i, "creator " +i, 45, (short)(2017+i), i, serie));
        }

        return chapters;
    }
    
    
    @Override
    public void view() {

    	super.view();
    	
    	ArrayList<Chapter>  chapters = getSerie().getChapters();
    	int chapterViewedCounter=0;
    	
    	for (Chapter chapter : chapters) {
			if(chapter.getIsviewed()) {
				chapterViewedCounter++;
			}
		}
    	
    	if(chapterViewedCounter==chapters.size()) {
    		getSerie().view();
    	}
    	
    	
    }
    
    
    
}