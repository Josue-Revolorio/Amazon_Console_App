package com.Jcode.AmazonViewer.Model;
import java.util.ArrayList;

public class Serie extends Film {
	
	// Attributes
	
	private int id;
	private int sessionQuantity;
	private ArrayList<Chapter> chapters;
	
	public Serie(String title, String genre, String creator, int duration, int sessionQuantity) {
		super(title, genre, creator, duration);
		this.sessionQuantity = sessionQuantity;
	}
	
	// Getters y Setters
	public int getId() {
		return id;
	}

	public int getSessionQuantity() {
		return sessionQuantity;
	}

	public void setSessionQuantity(int sessionQuantity) {
		this.sessionQuantity = sessionQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	
	// Overwriting toString 
	@Override
    public String toString() {
        return  "\n :: SERIES ::" +
                "\n Title: "      + getTitle() +
                "\n Genre: "      + getGenre() +
                "\n Year: "       + getYear() +
                "\n Creator: "    + getCreator() +
                "\n Duration: "   + getDuration();
    }
	
	
	// Method generates a list of series
    public static ArrayList<Serie> makeSeriesList() {
        ArrayList<Serie> series = new ArrayList<Serie>();

        for (int i = 1; i <= 5; i++) {
        	Serie serie = new Serie("Serie "+i, "genero "+i, "creador "+i, 1200, 5);
			serie.setChapters(Chapter.makeChaptersList(serie));
			series.add(serie);
        }

        return series;
    }

	@Override
	public void view() {
		setViewed(true);
		
	}
	
}