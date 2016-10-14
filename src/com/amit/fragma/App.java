package com.amit.fragma;

import com.amit.fragma.persistance.IPersistence;
import com.amit.fragma.persistance.Persistance;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		IPersistence persistence = Persistance.getInstance();
		persistence.getTopTenMostViewMovie("DESC");
		persistence.getTopTwentyRatedMovies();
		persistence.getTopTwentyRatedByAges();
		persistence.getTopTenCritics();

		


	}

}
