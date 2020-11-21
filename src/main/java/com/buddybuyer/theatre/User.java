package com.buddybuyer.theatre;
import com.buddybuyer.media.*;
import java.util.Set;
import java.util.HashSet;

public class User {
	public User(String name) {
		this.name = name;
	}
	String name;
	Set<User> friends = new HashSet<>();
	
	public Set<User> getFriends() {
		return friends;
	}
	
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
		if (o instanceof User) {
			User c = (User)o;
			return this.name.equals(c.name);
		}
		return false;
	}
}
