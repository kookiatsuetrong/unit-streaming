package com.buddybuyer.media;

public class Media {
	public Media(String title, int rating, Genre genre, Creator creator) {
		this.title = title;
		this.rating = rating;
		this.genre = genre;
		this.creator = creator;
	}
	String title;
	int rating;
	Genre genre;
	Creator creator;
	
	@Override public int hashCode() {
		return title.hashCode();
	}
	@Override public boolean equals(Object o) {
		if (o instanceof Media) {
			Media c = (Media)o;
			return this.title.equals(c.title);
		}
		return false;
	}
	public String getTitle() { 
		return title; 
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int r) {
		this.rating = r;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre g) {
		this.genre = g;
	}
	public Creator getCreator() {
		return creator;
	}
	public void setCreator(Creator c) {
		this.creator = c;
	}
}


