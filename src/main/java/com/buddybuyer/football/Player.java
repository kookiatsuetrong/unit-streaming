package com.buddybuyer.football;

public class Player {
	public Player(String s, int n) {
		name = s;
		number = n;
	}
	String name = "";
	int number = 0;
	public void setName(String s) {
		name = s;
	}
	public void setNumber(int n) {
		number = n;
	}
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	@Override public int hashCode() {
		return name.hashCode();
	}
	@Override public boolean equals(Object o) {
		if (o instanceof Player) {
			Player p = (Player)o;
			return name.equals(p.name);
		}
		return false;
	}
}