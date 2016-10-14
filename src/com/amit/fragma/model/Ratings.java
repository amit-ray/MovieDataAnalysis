package com.amit.fragma.model;

import java.util.Date;

public class Ratings {
	private int userID;
	private int moviewID;
	private int rating;
	private Date timestamp;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getMoviewID() {
		return moviewID;
	}
	public void setMoviewID(int moviewID) {
		this.moviewID = moviewID;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
