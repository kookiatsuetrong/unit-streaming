package com.buddybuyer.model;

public class Viewer {
	public Viewer(String name) {
		this.name = name;
	}
	String name;
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


