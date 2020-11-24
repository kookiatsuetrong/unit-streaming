package com.buddybuyer.service;
import org.junit.Assert;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import com.buddybuyer.online.User;
import com.buddybuyer.online.Movie;

public class OnlineTest {
	
	public void testA001() {
		User u1 = new User(1, "U1");
		User u2 = new User(2, "U2");
		User u3 = new User(3, "U3");
		Movie m = new Movie(1, "M1", 4);
		m.addWatchedList(1);
		m.addWatchedList(2);
		Set<Movie> movies = new HashSet<Movie>();
		OnlineService os = new OnlineService(movies);
		boolean r = os.isWatchedList(m, u2);
		Assert.assertTrue(r);
	}
	
	public void testA002() {
		User u1 = new User(1, "U1");
		User u2 = new User(2, "U2");
		User u3 = new User(3, "U3");
		Movie m = new Movie(1, "M1", 4);
		m.addWatchedList(1);
		m.addWatchedList(2);
		Set<Movie> movies = new HashSet<Movie>();
		OnlineService os = new OnlineService(movies);
		boolean r = os.isWatchedList(m, u3);
		Assert.assertFalse(r);
	}
	
	public void testB001() {
		User u1 = new User(1, "U1");
		User u2 = new User(2, "U2");
		User u3 = new User(3, "U3");
		Movie m1 = new Movie(1, "M1", 4);
		m1.addWatchedList(1);
		m1.addWatchedList(2);
		Set<Movie> movies = new HashSet<Movie>();
		OnlineService os = new OnlineService(movies);
		Set<Movie> result = os.getWatchedList(u3);
		Set<Movie> expected = new HashSet<>();
		Assert.assertTrue( expected.containsAll(result) );
	}
	
	public void testB002() {
		User u1 = new User(1, "U1");
		User u2 = new User(2, "U2");
		User u3 = new User(3, "U3");
		Movie m1 = new Movie(1, "M1", 4);
		m1.addWatchedList(1);
		m1.addWatchedList(2);
		Movie m2 = new Movie(2, "M2", 4);
		m2.addWatchedList(1);
		Set<Movie> movies = new HashSet<Movie>();
		OnlineService os = new OnlineService(movies);
		Set<Movie> result = os.getWatchedList(u1);
		Set<Movie> expected = new HashSet<>();
		expected.add(m1);
		expected.add(m2);
		Assert.assertTrue( expected.containsAll(result) );
	}
	
	public void testB003() {
		User u1 = new User(1, "U1");
		User u2 = new User(2, "U2");
		User u3 = new User(3, "U3");
		Movie m1 = new Movie(1, "M1", 4);
		m1.addWatchedList(1);
		m1.addWatchedList(2);
		Movie m2 = new Movie(2, "M2", 4);
		m2.addWatchedList(1);
		Set<Movie> movies = new HashSet<Movie>();
		OnlineService os = new OnlineService(movies);
		Set<Movie> result = os.getWatchedList(u2);
		Set<Movie> expected = new HashSet<>();
		expected.add(m1);
		Assert.assertTrue( expected.containsAll(result) );
	}
	
	public void testZ001() {
		User u0 = new User(0, "U0");
		User u1 = new User(1, "U1");
		User u2 = new User(2, "U2");
		User u3 = new User(3, "U3");
		Set<User> f = u0.getFriends();
		f.add(u1);
		f.add(u2);
		Movie m1 = new Movie(1, "M1", 4);
		m1.addWatchedList(1);
		m1.addWatchedList(2);
		Movie m2 = new Movie(2, "M2", 4);
		m2.addWatchedList(1);
		Set<Movie> movies = new HashSet<Movie>();
		movies.add(m1);
		movies.add(m2);
		OnlineService os = new OnlineService(movies);
		List<Movie> result = os.suggestMovies(u0);
		List<Movie> expected = new ArrayList<>();
		expected.add(m1);
		expected.add(m2);
		Assert.assertEquals(expected, result);
	}
	
	public void testZ002() {
		User u0 = new User(0, "U0");
		User u1 = new User(1, "U1");
		User u2 = new User(2, "U2");
		User u3 = new User(3, "U3");
		Set<User> f = u0.getFriends();
		f.add(u2);
		f.add(u3);
		Movie m1 = new Movie(1, "M1", 4);
		m1.addWatchedList(1);
		m1.addWatchedList(2);
		Movie m2 = new Movie(2, "M2", 4);
		m2.addWatchedList(1);
		Set<Movie> movies = new HashSet<Movie>();
		movies.add(m1);
		movies.add(m2);
		OnlineService os = new OnlineService(movies);
		List<Movie> result = os.suggestMovies(u0);
		List<Movie> expected = new ArrayList<>();
		expected.add(m1);
		Assert.assertEquals(expected, result);
	}
	
	public void testZ003() {
		User u0 = new User(0, "U0");
		User u1 = new User(1, "U1");
		User u2 = new User(2, "U2");
		User u3 = new User(3, "U3");
		Set<User> f = u0.getFriends();
		f.add(u1);
		f.add(u2);
		f.add(u3);
		Movie m1 = new Movie(1, "M1", 4);
		Movie m2 = new Movie(2, "M2", 4);
		Set<Movie> movies = new HashSet<Movie>();
		movies.add(m1);
		movies.add(m2);
		OnlineService os = new OnlineService(movies);
		List<Movie> result = os.suggestMovies(u0);
		List<Movie> expected = new ArrayList<>();
		Assert.assertEquals(expected, result);
	}
	
	public void testZ004() {
		User u0 = new User(0, "U0");
		User u1 = new User(1, "U1");
		User u2 = new User(2, "U2");
		User u3 = new User(3, "U3");
		Set<User> f = u0.getFriends();
		f.add(u1);
		Movie m1 = new Movie(1, "M1", 4);
		Movie m2 = new Movie(2, "M2", 4);
		Movie m3 = new Movie(3, "M3", 4);
		Movie m4 = new Movie(4, "M4", 4);
		Movie m5 = new Movie(5, "M5", 4);
		m2.addWatchedList(1);
		m3.addWatchedList(1);
		m4.addWatchedList(1);
		m5.addWatchedList(1);
		Set<Movie> movies = new HashSet<Movie>();
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		movies.add(m4);
		movies.add(m5);
		OnlineService os = new OnlineService(movies);
		List<Movie> result = os.suggestMovies(u0);
		List<Movie> expected = new ArrayList<>();
		expected.add(m2);
		expected.add(m3);
		expected.add(m4);
		expected.add(m5);
		Assert.assertEquals(expected, result);
	}
	
	public void testZ005() {
		User u0 = new User(0, "U0");
		User u1 = new User(1, "U1");
		User u2 = new User(2, "U2");
		User u3 = new User(3, "U3");
		Set<User> f = u0.getFriends();
		f.add(u1);
		f.add(u2);
		f.add(u3);
		Movie m1 = new Movie(1, "M1", 4);
		Movie m2 = new Movie(2, "M2", 4);
		Movie m3 = new Movie(3, "M3", 4);
		Movie m4 = new Movie(4, "M4", 4);
		Movie m5 = new Movie(5, "M5", 4);
		m2.addWatchedList(1);
		m3.addWatchedList(1);
		m4.addWatchedList(1);
		m5.addWatchedList(1);
		m5.addWatchedList(3);
		Set<Movie> movies = new HashSet<Movie>();
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		movies.add(m4);
		movies.add(m5);
		OnlineService os = new OnlineService(movies);
		List<Movie> result = os.suggestMovies(u0);
		List<Movie> expected = new ArrayList<>();
		expected.add(m5);
		expected.add(m2);
		expected.add(m3);
		expected.add(m4);
		Assert.assertEquals(expected, result);
	}
	
	public void testZ006() {
		User u0 = new User(0, "U0");
		User u1 = new User(1, "U1");
		User u2 = new User(2, "U2");
		User u3 = new User(3, "U3");
		Set<User> f = u0.getFriends();
		f.add(u1);
		f.add(u2);
		f.add(u3);
		Movie m2 = new Movie(2, "M2", 4);
		Movie m3 = new Movie(3, "M3", 4);
		Movie m4 = new Movie(4, "M4", 4);
		Movie m5 = new Movie(5, "M5", 4);
		m2.addWatchedList(1);
		m3.addWatchedList(1);
		m4.addWatchedList(1);
		m5.addWatchedList(1);
		m5.addWatchedList(3);
		Set<Movie> movies = new HashSet<Movie>();
		movies.add(m2);
		movies.add(m3);
		movies.add(m4);
		movies.add(m5);
		OnlineService os = new OnlineService(movies);
		List<Movie> result = os.suggestMovies(u0);
		List<Movie> expected = new ArrayList<>();
		expected.add(m5);
		expected.add(m2);
		expected.add(m3);
		expected.add(m4);
		Assert.assertEquals(expected, result);
	}
	
	public void testZ007() {
		User u0 = new User(0, "U0");
		User u1 = new User(1, "U1");
		User u2 = new User(2, "U2");
		User u3 = new User(3, "U3");
		Set<User> f = u0.getFriends();
		f.add(u1);
		f.add(u2);
		Movie m1 = new Movie(1, "M1", 4);
		Movie m2 = new Movie(2, "M2", 4);
		Movie m3 = new Movie(3, "M3", 4);
		Movie m4 = new Movie(4, "M4", 4);
		Movie m5 = new Movie(5, "M5", 4);
		Movie m6 = new Movie(6, "M6", 4);
		m2.addWatchedList(2);
		m1.addWatchedList(1);
		m3.addWatchedList(3);
		Set<Movie> movies = new HashSet<Movie>();
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		movies.add(m4);
		movies.add(m5);
		movies.add(m6);
		OnlineService os = new OnlineService(movies);
		List<Movie> result = os.suggestMovies(u0);
		List<Movie> expected = new ArrayList<>();
		expected.add(m1);
		expected.add(m2);
		Assert.assertEquals(expected, result);
	}
}
