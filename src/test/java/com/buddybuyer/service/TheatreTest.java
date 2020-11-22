package com.buddybuyer.service;
import org.junit.Assert;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import com.buddybuyer.theatre.User;
import com.buddybuyer.theatre.Movie;

public class TheatreTest {
	public void testA001() {
		User u = new User("U");
		User f1 = new User("F1");
		User f2 = new User("F2");
		User f3 = new User("F3");
		User f4 = new User("F4");
		Set<User> f = u.getFriends();
		f.add(f1);
		f.add(f2);
		f.add(f3);
		f.add(f4);
		TheatreService service = new TheatreService();
		Set<String> r = service.listFriends(u);
		Set<String> e = new HashSet<String>();
		e.add("F1");
		e.add("F2");
		e.add("F3");
		e.add("F4");
		Assert.assertTrue(e.containsAll(r));
	}
	public void testA002() {
		User u = new User("U");
		TheatreService service = new TheatreService();
		Set<String> r = service.listFriends(u);
		Set<String> e = new HashSet<String>();
		Assert.assertTrue(e.containsAll(r));
	}
	public void testA003() {
		User u = new User("U");
		User f1 = new User("F1");
		User f2 = new User("F2");
		User f3 = new User("F3");
		User f4 = new User("F4");
		Set<User> f = u.getFriends();
		f.add(f1);
		f.add(f2);
		f.add(f3);
		f.add(f4);
		f.add(new User("F1") );
		f.add(new User("F2") );
		TheatreService service = new TheatreService();
		Set<String> r = service.listFriends(u);
		Set<String> e = new HashSet<String>();
		e.add("F1");
		e.add("F4");
		e.add("F2");
		e.add("F3");
		Assert.assertTrue(e.containsAll(r));
	}
	public void testB001() {
		User u = new User("U");
		User f1 = new User("F1");
		User f2 = new User("F2");
		User f3 = new User("F3");
		User f4 = new User("F4");
		Set<User> f = u.getFriends();
		f.add(f1);
		f.add(f3);
		f.add(f4);
		f.add(f3);
		f.add(f2);
		TheatreService service = new TheatreService();
		List<String> r = service.listSortedFriends(u);
		List<String> e = new ArrayList<String>();
		e.add("F1");
		e.add("F2");
		e.add("F3");
		e.add("F4");
		Assert.assertEquals( e, r );
	}
	public void testB002() {
		User u = new User("U");
		User f1 = new User("F1");
		Set<User> f = u.getFriends();
		f.add(f1);
		TheatreService service = new TheatreService();
		List<String> r = service.listSortedFriends(u);
		List<String> e = new ArrayList<String>();
		e.add("F1");
		Assert.assertEquals( e, r );
	}
	public void testB003() {
		User u = new User("U");
		TheatreService service = new TheatreService();
		List<String> r = service.listSortedFriends(u);
		List<String> e = new ArrayList<String>();
		Assert.assertEquals( e, r );
	}
		
	public void testC001() {
		User u = new User("U");
		User f1 = new User("F1");
		User f2 = new User("F2");
		User f3 = new User("F3");
		User f4 = new User("F4");
		Set<User> f = u.getFriends();
		f.add(f1);
		f.add(f2);
		f.add(f3);
		f.add(f4);
		TheatreService service = new TheatreService();
		Set<User> r = service.getCommonFriends(u, u);
		Set<User> e = new HashSet<User>();
		e.add(new User("F1"));
		e.add(new User("F2"));
		e.add(new User("F3"));
		e.add(new User("F4"));
		Assert.assertTrue(e.containsAll(r));
	}
	
	public void testC002() {
		User u = new User("U");
		User f1 = new User("F1");
		User f2 = new User("F2");
		User f3 = new User("F3");
		User f4 = new User("F4");
		Set<User> f = u.getFriends();
		f.add(f1);
		f.add(f2);
		f.add(f3);
		f.add(f4);
		User v = new User("V");
		Set<User> g = v.getFriends();
		TheatreService service = new TheatreService();
		Set<User> r = service.getCommonFriends(u, v);
		Set<User> e = new HashSet<User>();
		Assert.assertTrue(e.containsAll(r));
	}
	
	public void testC003() {
		User u = new User("U");
		Set<User> f = u.getFriends();
		f.add(new User("F1"));
		f.add(new User("F2"));
		f.add(new User("F3"));
		f.add(new User("F4"));
		User v = new User("V");
		Set<User> g = v.getFriends();
		g.add(new User("F3"));
		f.add(new User("F2"));
		f.add(new User("F1"));
		TheatreService service = new TheatreService();
		Set<User> r = service.getCommonFriends(u, v);
		Set<User> e = new HashSet<User>();
		e.add(new User("F1"));
		e.add(new User("F2"));
		e.add(new User("F3"));
		Assert.assertTrue(e.containsAll(r));
	}
	
	public void testC004() {
		User u = new User("U");
		Set<User> f = u.getFriends();
		f.add(new User("F1"));
		f.add(new User("F2"));
		f.add(new User("F3"));
		f.add(new User("F4"));
		User v = new User("V");
		Set<User> g = v.getFriends();
		g.add(new User("F5"));
		f.add(new User("F6"));
		f.add(new User("F7"));
		TheatreService service = new TheatreService();
		Set<User> r = service.getCommonFriends(u, v);
		Set<User> e = new HashSet<User>();
		Assert.assertTrue(e.containsAll(r));
	}
	
	public void testD001() {
		Movie m1 = new Movie("M1", 4);
		Movie m2 = new Movie("M2", 4);
		Movie m3 = new Movie("M3", 4);
		Movie m4 = new Movie("M4", 4);
		Movie m5 = new Movie("M5", 4);
		User u1 = new User("U1");
		u1.addToWatchedList(m1);
		u1.addToWatchedList(m2);
		u1.addToWatchedList(m3);
		u1.addToWatchedList(m4);
		User u2 = new User("U2");
		u2.addToWatchedList(m4);
		u2.addToWatchedList(m1);
		TheatreService service = new TheatreService();
		
		Set<Movie> result = service.getCommonWatchedList(u1, u2);
		Set<Movie> e = new HashSet<Movie>();
		e.add(m1);
		e.add(m4);
		
		Assert.assertTrue(e.containsAll(result));
	}
	public void testD002() {
		Movie m1 = new Movie("M1", 4);
		Movie m2 = new Movie("M2", 4);
		Movie m3 = new Movie("M3", 4);
		Movie m4 = new Movie("M4", 4);
		Movie m5 = new Movie("M5", 4);
		User u1 = new User("U1");
		u1.addToWatchedList(m1);
		u1.addToWatchedList(m2);
		u1.addToWatchedList(m3);
		User u2 = new User("U2");
		u2.addToWatchedList(m5);
		u2.addToWatchedList(m4);
		TheatreService service = new TheatreService();
		
		Set<Movie> result = service.getCommonWatchedList(u1, u2);
		Set<Movie> e = new HashSet<Movie>();
		
		Assert.assertTrue(e.containsAll(result));
	}
	
	public void testZ001() {
		Movie m1 = new Movie("M1", 4);
		Movie m2 = new Movie("M2", 4);
		Movie m3 = new Movie("M3", 4);
		Movie m4 = new Movie("M4", 4);
		Movie m5 = new Movie("M5", 4);
		User u = new User("U");
		User f1 = new User("F1");
		f1.addToWatchedList(m1);
		f1.addToWatchedList(m2);
		f1.addToWatchedList(m3);
		User f2 = new User("F2");
		f2.addToWatchedList(m4);
		f2.addToWatchedList(m5);
		Set<User> f = u.getFriends();
		f.add(f1);
		f.add(f2);
		TheatreService service = new TheatreService();
		List<Movie> result = service.suggestMovie(u);
		List<Movie> e = new ArrayList<Movie>();
		e.add(m1);
		e.add(m2);
		e.add(m3);
		e.add(m4);
		Assert.assertEquals(e, result);
	}
	public void testZ002() {
		Movie m1 = new Movie("M1", 4);
		Movie m2 = new Movie("M2", 4);
		Movie m3 = new Movie("M3", 4);
		Movie m4 = new Movie("M4", 4);
		Movie m5 = new Movie("M5", 4);
		User u = new User("U");
		User f1 = new User("F1");
		f1.addToWatchedList(m1);
		f1.addToWatchedList(m2);
		f1.addToWatchedList(m3);
		User f2 = new User("F2");
		f2.addToWatchedList(m3);
		f2.addToWatchedList(m4);
		f2.addToWatchedList(m5);
		Set<User> f = u.getFriends();
		f.add(f1);
		f.add(f2);
		TheatreService service = new TheatreService();
		List<Movie> result = service.suggestMovie(u);
		List<Movie> e = new ArrayList<Movie>();
		e.add(m3);
		e.add(m1);
		e.add(m2);
		e.add(m4);
		Assert.assertEquals(e, result);
	}
	
	public void testZ003() {
		Movie m1 = new Movie("M1", 4);
		Movie m2 = new Movie("M2", 4);
		Movie m3 = new Movie("M3", 4);
		Movie m4 = new Movie("M4", 4);
		Movie m5 = new Movie("M5", 4);
		User u = new User("U");
		User f1 = new User("F1");
		f1.addToWatchedList(m1);
		User f2 = new User("F2");
		f2.addToWatchedList(m5);
		Set<User> f = u.getFriends();
		f.add(f1);
		f.add(f2);
		TheatreService service = new TheatreService();
		List<Movie> result = service.suggestMovie(u);
		List<Movie> e = new ArrayList<Movie>();
		e.add(m1);
		e.add(m5);
		Assert.assertEquals(e, result);
	}
	public void testZ004() {
		Movie m1 = new Movie("M1", 4);
		Movie m2 = new Movie("M2", 4);
		Movie m3 = new Movie("M3", 4);
		Movie m4 = new Movie("M4", 4);
		Movie m5 = new Movie("M5", 4);
		User u = new User("U");
		User f1 = new User("F1");
		f1.addToWatchedList(m1);
		User f2 = new User("F2");
		f2.addToWatchedList(m5);
		Set<User> f = u.getFriends();
		f.add(f1);
		f.add(f2);
		TheatreService service = new TheatreService();
		List<Movie> result = service.suggestMovie(u);
		List<Movie> e = new ArrayList<Movie>();
		e.add(m1);
		e.add(m5);
		Assert.assertEquals(e, result);
	}
	public void testZ005() {
		User u = new User("U");
		TheatreService service = new TheatreService();
		List<Movie> result = service.suggestMovie(u);
		List<Movie> e = new ArrayList<Movie>();
		Assert.assertEquals(e, result);
	}
	public void testZ006() {
		Movie m1 = new Movie("M1", 4);
		Movie m2 = new Movie("M2", 4);
		Movie m3 = new Movie("M3", 4);
		Movie m4 = new Movie("M4", 4);
		Movie m5 = new Movie("M5", 4);
		User u = new User("U");
		User f1 = new User("F1");
		f1.addToWatchedList(m3);
		f1.addToWatchedList(m4);
		User f2 = new User("F2");
		f2.addToWatchedList(m1);
		f2.addToWatchedList(m2);
		Set<User> f = u.getFriends();
		f.add(f1);
		f.add(f2);
		TheatreService service = new TheatreService();
		List<Movie> result = service.suggestMovie(u);
		List<Movie> e = new ArrayList<Movie>();
		e.add(m1);
		e.add(m2);
		e.add(m3);
		e.add(m4);
		Assert.assertEquals(e, result);
	}
	public void testZ007() {
		Movie m1 = new Movie("M1", 4);
		Movie m2 = new Movie("M2", 4);
		Movie m3 = new Movie("M3", 4);
		Movie m4 = new Movie("M4", 4);
		Movie m5 = new Movie("M5", 4);
		User u = new User("U");
		User f1 = new User("F1");
		f1.addToWatchedList(m3);
		f1.addToWatchedList(m4);
		f1.addToWatchedList(m5);
		User f2 = new User("F2");
		f2.addToWatchedList(m1);
		f2.addToWatchedList(m2);
		Set<User> f = u.getFriends();
		f.add(f1);
		f.add(f2);
		TheatreService service = new TheatreService();
		List<Movie> result = service.suggestMovie(u);
		List<Movie> e = new ArrayList<Movie>();
		e.add(m1);
		e.add(m2);
		e.add(m3);
		e.add(m4);
		Assert.assertEquals(e, result);
	}
	public void testZ008() {
		Movie m1 = new Movie("M1", 4);
		Movie m2 = new Movie("M2", 4);
		Movie m3 = new Movie("M3", 4);
		Movie m4 = new Movie("M4", 4);
		Movie m5 = new Movie("M5", 4);
		User u = new User("U");
		User f1 = new User("F1");
		f1.addToWatchedList(m3);
		f1.addToWatchedList(m4);
		f1.addToWatchedList(m5);
		User f2 = new User("F2");
		f2.addToWatchedList(m1);
		f2.addToWatchedList(m2);
		f2.addToWatchedList(m5);
		Set<User> f = u.getFriends();
		f.add(f1);
		f.add(f2);
		TheatreService service = new TheatreService();
		List<Movie> result = service.suggestMovie(u);
		List<Movie> e = new ArrayList<Movie>();
		e.add(m5);
		e.add(m1);
		e.add(m2);
		e.add(m3);
		Assert.assertEquals(e, result);
	}
}
