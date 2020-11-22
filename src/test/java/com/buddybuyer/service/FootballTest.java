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
			
			sm.execute("  create table players(" +
						" name varchar(80) unique not null, " +
						" number int)");
			sm.execute("insert into players(name,number) values('P1', 1)");
			sm.execute("insert into players(name,number) values('P2', 2)");
			sm.execute("insert into players(name,number) values('P3', 3)");
			sm.close();
			cn.close();
		} catch (Exception e) { }
	}
	
	public void test000() {
		FootballService fs = new FootballService();
		List<Player> result = fs.getPlayers();
		List<Player> expected = new ArrayList<>();
		expected.add(new Player("P1", 1));
		expected.add(new Player("P2", 2));
		expected.add(new Player("P3", 3));
		Assert.assertEquals(expected, result);
	}
	
	/*
	public void test001() {
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
	public void test002() {
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
