package com.buddybuyer.online;
import java.util.Set;
import java.util.HashSet;

public class User {
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	int id;
	String name;
	Set<User> friends = new HashSet<>();	
	public Set<User> getFriends() {
		return friends;
	}
	public int getId() {
		return id;
	}
	public void setId(int k) {
		id = k;
	}
	public String getName() { 
		return name; 
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override public int hashCode() {
		return this.id;
	}
	@Override public boolean equals(Object o) {
		if (o instanceof User) {
			User c = (User)o;
			return this.id == c.id;
		}
		return false;
	}
}
