package com.buddybuyer.service;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.buddybuyer.online.User;
import com.buddybuyer.online.Movie;

public class OnlineService {
	public OnlineService(Set<Movie> movies) {
		this.movies = movies;
	}
	Set<Movie> movies;
	
	/*
	A:  The method boolean isWatchedList(Movie m, User u) 
		will return true if the given user is in the list of 
		watched list of given movie.
	*/
	public boolean isWatchedList(Movie m, User u) {
		return false; // Remove this line and write your code
	}
	/*
	B:  The method Set<Movie> getWatchedList(User u)
		will return all movies from the watched list of
		the given user
	*/
	public Set<Movie> getWatchedList(User u) {
		return null; // Remove this line and write your code
	}
	
	/*
	Z:  Implement List<Movie> suggestMovies(User user) method that will 
		return a list of top four movie titles, that have been most 
		watchlisted by friends of the given user.
		Movies that have equal watchlist count, should be ordered 
		alphabetically.
	*/
	public List<Movie> suggestMovies(User user) {
		return null; // Remove this line and write your code
	}
}

	/*
	:  The method String getMostPopular()
		will return the title of the most popular movie
		from the watched list, if there are more one movie
		return the first 
	*/
	
	/*
	:  The method Set<Movie> showMovies(User) will return
		all movie titles from 
	
	*/