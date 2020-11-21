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
	Set<Movie> watchedList = new HashSet<>();
	
	public Set<User> getFriends() {
		return friends;
	}
	
	public Set<Movie> getWatchedList() {
		return watchedList;
	}
	public void addToWatchedList(Movie m) {
		watchedList.add(m);
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
