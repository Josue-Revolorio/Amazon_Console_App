package com.Jcode.AmazonViewer.Model;
import java.util.ArrayList;
import java.util.Date;

import com.Jcode.AmazonViewer.dao.MovieDAO;

public class Movie extends Film implements Ivisualizable , MovieDAO{
	
	// Attributes
	private int id; 
	private int timeViewed;
	
	// builder method
	
	
	public Movie() {
		
	}
	
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
        setYear(year);
		
	}
	
	// Getters y Setters 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}
	
	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	
	//Overwriting toString
    @Override
    public String toString() {
        return  "\n :: MOVIE ::" +
                "\n Title: " + getTitle() +
                "\n Genre: " + getGenre() +
                "\n Year: "  + getYear()  +
                "\n Creator: "  + getCreator() +
                "\n Duration: " + getDuration();
    }

    //Method of Interface
    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }
    
    //Subtract the start time of the end time
    @Override
    public void stopToSee(Date dateI, Date dateF) {

        if( dateF.getTime() > dateI.getTime()){
            setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
        }else{
            setTimeViewed(0);
        }
    }

    // Method generates a list of movies
    public static ArrayList<Movie> makeMoviesList(){
    	
        Movie movie = new Movie();
        
        
        return movie.read();
    }

	@Override
	public void view() {
		
		setViewed(true);
		
		Movie movie = new Movie();
		movie.setMovieViewed(this);
		
        
        //start watching movie
        Date dateI = startToSee(new Date());
               
        
        //simulate movie
        for (int i = 0; i < 10000; i++) {
            System.out.println("..........");
        }

        //Finish watching the movie
        stopToSee(dateI, new Date());
        
        //information about the movie
        System.out.println("\n" + "Viste: " + toString());
        System.out.println("Por: " + getTimeViewed() + " milisegundos");
		
	}

}