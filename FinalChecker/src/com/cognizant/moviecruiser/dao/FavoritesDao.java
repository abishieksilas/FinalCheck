/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

/**
 * @author Abishiek
 *
 */
public interface FavoritesDao {
	public void addFavorites(long userId, long movieId);

	// public List<MenuItem> getAllCartItem(long userId) throws
	// CartEmptyException;
	public void removeFavorites(long userId, long movieId);

	List<Movie> getAllFavorites(long userid) throws FavoritesEmptyException;
}
