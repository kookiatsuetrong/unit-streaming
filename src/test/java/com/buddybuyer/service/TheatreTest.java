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
}