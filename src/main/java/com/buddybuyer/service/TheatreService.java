package com.buddybuyer.service;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import com.buddybuyer.theatre.User;
import com.buddybuyer.theatre.Movie;

public class TheatreService {
	
	/*
	A:  The method Set<String> listFriends(User user) will return 
		all name of friends of the given user in any order.
	*/
	Set<String> listFriends(User user) {
		return null; // Remove this line to write your code.
	}
	
	/*
	B:  The method List<String> listFriends(User user) will return 
		all name of friends of the given user, sorted by name.
	*/
	List<String> listSortedFriends(User user) {
		return null; // Remove this line to write your code.
	}
	/*
	C:  The method Set<User> getCommonFriends(User u, User v) will return 
		all common friends of two given users.
	*/
	Set<User> getCommonFriends(User u, User v) {
		return null; // Remove this line to write your code.
	}
	
	/*
	D:  The method Set<Movie> getCommonWatchedList(User u, User v)
		will return all common watched list of both users in any order.
	*/
	Set<Movie> getCommonWatchedList(User u, User v) {
		return null; // Remove this line to write your code.
	}
	
	/*
	Z:  Implement List<Movie> suggestMovie(User user) method that will 
		return a list of top four movie titles, that have been most 
		watchlisted by friends of a given user.
		Movies that have equal watchlist count, should be ordered 
		alphabetically.
	*/
	List<Movie> suggestMovie(User user) {
		return null; // Remove this line to write your code.
	}
}
