/**
 * 
 */
package com.cognizant.moviecruiser.model;

import java.util.List;

/**
 * @author Abishiek
 *
 */
public class Favorites {
	private List<Movie> movieList;
	private long total;

	/**
 * 
 */
	public Favorites() {
		super();
	}

	/**
	 * @param movieList
	 * @param total
	 */
	public Favorites(List<Movie> movieList, long total) {
		super();
		this.movieList = movieList;
		this.total = total;
	}

	/**
	 * @return the movieList
	 */
	public List<Movie> getMovieList() {
		return movieList;
	}

	/**
	 * @param movieList
	 *            the movieList to set
	 */
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + ", total=" + total + "]";
	}

}
