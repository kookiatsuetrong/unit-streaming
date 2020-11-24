package com.buddybuyer.online;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Movie {
	public Movie(int id, String title, int rating) {
		this.id = id;
		this.title = title;
		this.rating = rating;
	}
	int id;
	String title;
	int rating;
	
	@Override public int hashCode() {
		return id;
	}
	@Override public boolean equals(Object o) {
		if (o instanceof Movie) {
			Movie c = (Movie)o;
			return this.id == c.id;
		}
		return false;
	}
	
	Set<Integer> watchedList = new HashSet<>();
	public Set<Integer> getWatchedlist() {
		return watchedList;
	}
	public void addWatchedList(int id) {
		watchedList.add(id);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
