package com.buddybuyer.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import com.buddybuyer.football.Player;

/*
Sample Database: football
Table: players
+------------+--------+-------------------+
| name       | number | club              |
+------------+--------+-------------------+
| Michael O  | 10     | Liverpool         |
| David B    | 7      | Manchester United |
| Frank L    | 8      | Chelsea           |
| Steven G   | 8      | Liverpool         |
.            .        .                   .
.            .        .                   .
.            .        .                   .
+------------+--------+-------------------+
*/

public class FootballService {
	/*
	Sample code to read player information from database
	*/
	List<Player> getPlayers() {
		List<Player> result = new ArrayList<>();
		try {
			String url = "jdbc:derby:memory:football;";
			Connection cn = DriverManager.getConnection(url);
			Statement sm = cn.createStatement();
			ResultSet rs = sm.executeQuery("select * from players");
			while (rs.next()) {
				String name = rs.getString("name");
				int number = rs.getInt("number");
				Player p = new Player(name);
				result.add(p);
			}
			rs.close();
			sm.close();
			cn.close();
		} catch (Exception e) { }
		
		return result;
	}
	/*
	A: Return player's number by given name, or -1 if not found.
	*/
	int getNumber(String name) {
		return -1;
	}
	
	// Given player, return club
	// Given club, return all players
	// Given club, count players
	// Insert a player to table
}
