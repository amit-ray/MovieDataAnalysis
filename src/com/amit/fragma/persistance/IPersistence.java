package com.amit.fragma.persistance;

import java.sql.SQLException;
import java.util.List;

import com.amit.fragma.model.Movie;
import com.amit.fragma.model.User;

public interface IPersistence {

	public List<Movie> getTopTenMostViewMovie(String order) throws SQLException;

	/**
	 * Top twenty rated movies (Condition : The movie should be rated/viewed by at least 40 users) 
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Movie> getTopTwentyRatedMovies() throws SQLException;

	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Movie> getTopTwentyRatedByAges() throws SQLException;

	public List<User> getTopTenCritics() throws SQLException;

}
