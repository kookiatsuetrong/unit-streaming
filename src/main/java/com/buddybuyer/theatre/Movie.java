package com.buddybuyer.theatre;


public class Movie {
	public Movie(String title, int rating) {
		this.title = title;
		this.rating = rating;
	}
	String title;
	int rating;
	
	@Override public int hashCode() {
		return title.hashCode();
	}
	@Override public boolean equals(Object o) {
		if (o instanceof Movie) {
			Movie c = (Movie)o;
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
}


