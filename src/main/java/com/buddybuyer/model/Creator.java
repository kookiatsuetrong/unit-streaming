
package com.buddybuyer.model;

public class Creator {
	public Creator(String name) {
		this.name = name;
	}
	String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	@Override public int hashCode() {
		return name.hashCode();
	}
	@Override public boolean equals(Object o) {
		if (o instanceof Creator) {
			Creator c = (Creator)o;
			return this.name.equals(c.name);
		}
		return false;
	}
}
