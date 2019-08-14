package com.Jcode.AmazonViewer.Model;
import java.util.Date;

public class Publication {
	
	// father class the Magazines y Books
    // Attributes
	private String title;
    private Date edititionDate;
    private String editorial;
    private String authors[];
    
    // builder method
	public Publication(String title, Date edititionDate, String editorial) {
		super();
		this.title = title;
		this.edititionDate = edititionDate;
		this.editorial = editorial;
	}

	// Getters y Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getEdititionDate() {
		return edititionDate;
	}

	public void setEdititionDate(Date edititionDate) {
		this.edititionDate = edititionDate;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	
	
}