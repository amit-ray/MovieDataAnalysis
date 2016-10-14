package com.amit.fragma.model;

public class Movie {
	
	private int id;
	private String titleMDB;
	private String genres;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitleMDB() {
		return titleMDB;
	}
	public void setTitleMDB(String titleMDB) {
		this.titleMDB = titleMDB;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}

}
