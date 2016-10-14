package com.amit.fragma.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amit.fragma.model.Movie;
import com.amit.fragma.model.User;

public class Persistance implements IPersistence {
	private Connection conn = null;
	private static Persistance persistence = null;

	private Persistance() {

	}

	private Connection getConnection() {
		try {
			String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			String DB_URL = "jdbc:mysql://localhost/movie";

			// Database credentials
			String USER = "root";
			String PASS = "";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

	public static Persistance getInstance() {

		if (persistence == null)
			persistence = new Persistance();

		return persistence;
	}

	@Override
	public List<Movie> getTopTenMostViewMovie(String order) throws SQLException {
		String sql = "select r.MovieID, m.TitleIMDB, m.Genres,  count(r.MovieID) AS maxviewed  from ratings as r INNER JOIN movies m on m.MovieID=r.MovieID Group By  r.MovieID ORDER BY `maxviewed` "
				+ order + " LIMIT 10";
		List<Movie> movieList = new ArrayList<Movie>();
		Statement createStatement = null;
		try {
			conn = getConnection();
			createStatement = conn.createStatement();

			ResultSet rs = createStatement.executeQuery(sql);

			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("MovieID"));
				movie.setTitleMDB(rs.getString("TitleIMDB"));
				movie.setGenres(rs.getString("Genres"));
				int viewed = rs.getInt("maxviewed");

				movieList.add(movie);
				System.out.println("Movie id :" + movie.getId() + "\tTotal viewed :" + viewed + " Movie name : "
						+ movie.getTitleMDB());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (createStatement != null) {
				createStatement.close();
			}

			if (conn != null) {
				conn.close();
			}

		}
		return movieList;
	}

	@Override
	public List<Movie> getTopTwentyRatedMovies() throws SQLException {
		String sql = "select r.MovieID, m.TitleIMDB, count(r.MovieID) AS maxviewed  from ratings as r INNER JOIN movies m on m.MovieID=r.MovieID Group By  r.MovieID having maxviewed >40 ORDER BY `maxviewed` DESC LIMIT 20";
		List<Movie> movieList = new ArrayList<Movie>();
		Statement createStatement = null;
		try {
			conn = getConnection();
			createStatement = conn.createStatement();

			ResultSet rs = createStatement.executeQuery(sql);

			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("MovieID"));
				movie.setTitleMDB(rs.getString("TitleIMDB"));
				movie.setGenres(rs.getString("Genres"));
				int viewed = rs.getInt("maxviewed");

				movieList.add(movie);
				System.out.println("Movie id :" + movie.getId() + "\tTotal viewed :" + viewed + " Movie name : "
						+ movie.getTitleMDB());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (createStatement != null) {
				createStatement.close();
			}

			if (conn != null) {
				conn.close();
			}

		}
		return movieList;
	}

	@Override
	public List<Movie> getTopTwentyRatedByAges() throws SQLException {
		String sql = "select r.MovieID, m.TitleIMDB, count(r.MovieID) AS maxviewed  from ratings as r INNER JOIN movies m on m.MovieID=r.MovieID Group By  r.MovieID having maxviewed >40 ORDER BY `maxviewed` DESC LIMIT 20";
		List<Movie> movieList = new ArrayList<Movie>();
		Statement createStatement = null;
		try {
			conn = getConnection();
			createStatement = conn.createStatement();

			ResultSet rs = createStatement.executeQuery(sql);

			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("MovieID"));
				movie.setTitleMDB(rs.getString("TitleIMDB"));
				movie.setGenres(rs.getString("Genres"));
				int viewed = rs.getInt("maxviewed");

				movieList.add(movie);

				String sql2 = "select count(r.UserID) as Users, SUM(CASE WHEN u.Age <20 THEN 1 ELSE 0 END) AS 'Young',SUM(CASE WHEN u.Age > 20 and u.age <40 THEN  1 ELSE 0 END) AS 'Young Adult',SUM(CASE WHEN u.Age > 40 THEN  1 ELSE 0 END) AS 'Adult' from ratings as r INNER JOIN users as u ON r.UserID=r.UserID WHERE r.MovieID=MovieID";
				ResultSet rs1 = createStatement.executeQuery(sql2);
				while (rs1.next()) {
					User user = new User();
					user.setId(rs.getInt("UserID"));
					user.setAge(rs1.getInt("Age"));

					System.out.println("Movie id :" + movie.getId() + "\tTotal viewed :" + viewed + " Movie name : "
							+ movie.getTitleMDB() + "User name :" + user.getId() + "Age Group" + user.getAge());

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (createStatement != null) {
				createStatement.close();
			}

			if (conn != null) {
				conn.close();
			}

		}
		return movieList;
	}

	@Override
	public List<User> getTopTenCritics() throws SQLException {
		String sql = "SELECT UserID,count(UserID) as critics, rating FROM `ratings` Group By UserID having critics >40 order by rating ASC limit 10";
		List<User> userList = new ArrayList<User>();
		Statement createStatement = null;
		try {
			conn = getConnection();
			createStatement = conn.createStatement();

			ResultSet rs = createStatement.executeQuery(sql);

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("UserID"));
				userList.add(user);
				System.out.println("User name :" + user.getId());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (createStatement != null) {
				createStatement.close();
			}

			if (conn != null) {
				conn.close();
			}

		}
		return userList;
	}

}
