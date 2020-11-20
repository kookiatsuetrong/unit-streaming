package com.buddybuyer.model;
import java.util.Set;
import java.util.HashSet;

public class Viewer {
	public Viewer(String name) {
		this.name = name;
	}
	String name;
	Set<Media> favouriteMedia  = new HashSet<>();
	Set<Genre> favouriteGenres = new HashSet<>();
	
	public void likeMedia(Media m) {
		favouriteMedia.add(m);
	}
	public Set<Media> getFavouriteMedia() {
		return favouriteMedia;
	}
	public void likeGenre(Genre g) {
		favouriteGenres.add(g);
	}
	public Set<Genre> getFavouriteGenres() {
		return favouriteGenres;
	}
	
	public String getName() { 
		return name; 
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override public int hashCode() {
		return name.hashCode();
	}
	@Override public boolean equals(Object o) {
		if (o instanceof Viewer) {
			Viewer c = (Viewer)o;
			return this.name.equals(c.name);
		}
		return false;
	}
}


