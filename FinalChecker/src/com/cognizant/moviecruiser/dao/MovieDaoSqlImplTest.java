/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * @author Abishiek
 *
 */
public class MovieDaoSqlImplTest {
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovie();

	}

	public static void testGetMovieListAdmin() {
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		System.out.println("Movie List Admin:\n"
				+ movieDaoSqlImpl.getMovieListAdmin());
		List<Movie> movies = movieDaoSqlImpl.getMovieListAdmin();
		for (Movie movie : movies) {
			System.out.println(movie.toString());
		}
	}

	public static void testGetMovieListCustomer() {
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		System.out.println("Movie List Customer:\n"
				+ movieDaoSqlImpl.getMovieListCustomer());
		List<Movie> movies = movieDaoSqlImpl.getMovieListCustomer();
		for (Movie movie : movies) {
			System.out.println(movie.toString());
		}
	}

	public static void testModifyMovie() throws ParseException {
		Movie movie = new Movie(2, "The Joker", 1854623412l, true,
				DateUtil.convertToDate("02/10/2019"), "Thriller", true);
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = movieDaoSqlImpl;
		movieDao.modifyMovie(movie);
		System.out.println("Modified Movie details are:\n"
				+ movieDao.getMovie(2));
	}

	
}
