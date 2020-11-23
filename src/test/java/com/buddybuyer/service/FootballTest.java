package com.buddybuyer.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;
import com.buddybuyer.football.Player;
/*
integer primary key generated always as identity(start with 1, increment by 1)
integer not null generated always as identity(start with 1, increment by 1)
*/
public class FootballTest {
	public FootballTest() {
		try {
			String url = "jdbc:derby:memory:football;create=true;";
			Connection cn = DriverManager.getConnection(url);
			Statement sm = cn.createStatement();
			
			sm.execute( " create table players(                 " +
						" name     varchar(80) unique not null, " +
						" number   int,                         " +
						" club     varchar(80)  )               " );
			
			sm.execute( " insert into players(name,number,club) " +
						" values('Machael O', 10, 'Liverpool')  ");
			
			sm.execute( " insert into players(name,number,club) " +
						" values('David B',7,'Machester United')");
			
			sm.execute( " insert into players(name,number,club) " +
						" values('Frank L', 8, 'Chelsea')       ");
			
			sm.execute( " insert into players(name,number,club) " +
						" values('Steven G', 8, 'Liverpool')    ");
			sm.close();
			cn.close();
		} catch (Exception e) { }
	}
	
	public void test001() {
		FootballService fs = new FootballService();
		int r = fs.getNumber("David B");
		Assert.assertEquals(7, r);
	}
	public void test002() {
		FootballService fs = new FootballService();
		int r = fs.getNumber("Frank L");
		Assert.assertEquals(8, r);
	}
	public void test003() {
		FootballService fs = new FootballService();
		int r = fs.getNumber("Steven G");
		Assert.assertEquals(8, r);
	}
	public void test004() {
		FootballService fs = new FootballService();
		String r = fs.getClub("Frank L");
		Assert.assertEquals("Chelsea", r);
	}
	public void test005() {
		FootballService fs = new FootballService();
		String r = fs.getClub("David B");
		Assert.assertEquals("Machester United", r);
	}
	public void test006() {
		FootballService fs = new FootballService();
		String r = fs.getClub("Steven G");
		Assert.assertEquals("Liverpool", r);
	}
	public void test007() {
		FootballService fs = new FootballService();
		String r = fs.getClub("James B");
		Assert.assertEquals(null, r);
	}
	
	/*
	public void testA() {
		FootballService fs = new FootballService();
		List<Player> result = fs.getPlayers();
		List<Player> expected = new ArrayList<>();
		expected.add(new Player("Machael O"));
		expected.add(new Player("David B"));
		expected.add(new Player("Frank L"));
		expected.add(new Player("Steven G"));
		Assert.assertEquals(expected, result);
	}
	*/
	
	/*
	public void testB() {
		int count = 0;
		try {
			String url = "jdbc:derby:memory:demo;create=true;";
			Connection cn = DriverManager.getConnection(url);
			Statement sm = cn.createStatement();
			
			sm.execute("create table users(email varchar(80) )");
			sm.execute("insert into users(email) values('james@mi6.com')");
			sm.execute("insert into users(email) values('bill@msn.com')");
			sm.execute("insert into users(email) values('mark@fb.com')");
			ResultSet rs = sm.executeQuery("select * from users");
			while (rs.next()) {
				String e = rs.getString("email");
				System.out.println(e);
				count++;
			}
			rs.close();
			sm.close();
			cn.close();
		} catch (Exception e) { }
		System.out.flush();
		Assert.assertEquals(3, count);
	}
	public void testC() {
		int count = 0;
		try {
			String url = "jdbc:derby:memory:demo;";
			Connection cn = DriverManager.getConnection(url);
			Statement sm = cn.createStatement();

			ResultSet rs = sm.executeQuery("select * from users");
			while (rs.next()) {
				count++;
			}
			rs.close();
			sm.close();
			cn.close();
		} catch (Exception e) { }
		Assert.assertEquals(3, count);
	}
	*/
}
