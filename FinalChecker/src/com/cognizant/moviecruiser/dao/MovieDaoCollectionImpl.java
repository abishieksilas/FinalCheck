/**
 * 
 */
package com.cognizant.moviecruiser.dao;

/**
 * @author Abishiek
 *
 */
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {
	private static List<Movie> movieList;

	public MovieDaoCollectionImpl() {
		super();
		if (movieList == null) {
			try {
				movieList = new ArrayList<Movie>();
				movieList.add(new Movie(1, "Avatar", 2787965087l, true,
						DateUtil.convertToDate("15/03/2017"),
						"Science Fiction", true));
				movieList.add(new Movie(2, "The Avengers", 1518812988l, true,
						DateUtil.convertToDate("23/12/2017"), "Superhero",
						false));
				movieList
						.add(new Movie(3, "Titanic", 2187463944l, true,
								DateUtil.convertToDate("21/08/2018"),
								"Romance", false));
				movieList.add(new Movie(4, "Jurassic World", 1671713208, false,
						DateUtil.convertToDate("02/07/2017"),
						"Science Fiction", true));
				movieList.add(new Movie(5, "Avengers:End Game", 2750760348l,
						true, DateUtil.convertToDate("02/11/2022"),
						"Superhero", true));
			} catch (ParseException pe) {
				System.out.println("ParseException " + pe.getMessage());
			}
		}
	}

	/**
	 * @return the movie
	 */
	public List<Movie> getMovie() {
		return movieList;
	}

	/**
	 * @param movie
	 *            the movie to set
	 */
	public void setMenuItem(List<Movie> movie) {
		this.movieList = movie;
	}

	public List<Movie> getMovieListAdmin() {
		return movieList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItemListCustomer()
	 */
	@Override
	public List<Movie> getMovieListCustomer() {
		// TODO Auto-generated method stub
		List<Movie> movieListCust = new ArrayList<Movie>();
		Date today = new Date();
		for (Movie mi : movieList) {
			if (mi.getDateOfLaunch().getTime() <= today.getTime()
					&& mi.isActive()) {
				movieListCust.add(mi);
			}
		}
		return movieListCust;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.truyum.dao.MenuItemDao#modifyMenuItem(com.cognizant.truyum
	 * .model.MenuItem)
	 */
	@Override
	public void modifyMovie(Movie movie) {
		// TODO Auto-generated method stub
		for (Movie mi : movieList) {
			if (movie.getId() == mi.getId()) {
				mi.setTitle(movie.getTitle());
				mi.setGenre(movie.getGenre());
				mi.setDateOfLaunch(movie.getDateOfLaunch());
				mi.setHasTeaser(movie.isHasTeaser());
				mi.setBoxOffice(movie.getBoxOffice());
				mi.setActive(movie.isActive());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItem(long)
	 */
	@Override
	public Movie getMovie(long movieId) {
		// TODO Auto-generated method stub
		for (Movie mi : movieList) {
			if (movieId == mi.getId()) {
				return mi;
			}
		}
		return null;
	}
}
