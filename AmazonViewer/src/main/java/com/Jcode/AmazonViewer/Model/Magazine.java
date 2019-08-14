package com.Jcode.AmazonViewer.Model;
import java.util.ArrayList;
import java.util.Date;

public class Magazine extends Publication{
	
	// Attributes
	private int id;

	// builder method
	public Magazine(String title, Date edititionDate, String editorial) {
		super(title, edititionDate, editorial);
	}

	// Getters y Setters
	public int getId() {
		return id;
	}
	
	// Overwriting toString
	@Override
    public String toString() {
        return  "\n :: MAGAZINE ::" +
                "\n Title: "        + getTitle() +
                "\n Editorial: "    + getEditorial() +
                "\n Edition Date: " + getEdititionDate();
    }

	// Method generates a list of Book
    public static ArrayList<Magazine> makeMagazineList() {
        ArrayList<Magazine> magazines = new ArrayList<Magazine>();
       /* String[] authors = new String[3];
       for (int i = 0; i < 3; i++) {
            authors[i] = "author "+i;
        }
        */
        for (int i = 1; i <= 5; i++) {
            magazines.add(new Magazine("Magazine " + i, new Date(), "Editorial " + i));
        }

        return magazines;
    }

}