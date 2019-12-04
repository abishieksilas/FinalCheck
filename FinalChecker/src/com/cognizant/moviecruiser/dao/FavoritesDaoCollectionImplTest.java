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
public class FavoritesDaoCollectionImplTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FavoritesEmptyException {
		// TODO Auto-generated method stub

		testAddFavorites();

		testRemoveFavorites();
		testGetAllFavorites();

	}

	static void testAddFavorites() throws FavoritesEmptyException {

		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;
		favoritesDao.addFavorites(2, 4);
		favoritesDao.addFavorites(2, 3);
		List<Movie> movieList = favoritesDao.getAllFavorites(2);
		System.out.println("Movie list :\n" + movieList);

	}

	static void testGetAllFavorites() throws FavoritesEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;

		List<Movie> movieList = favoritesDao.getAllFavorites(2);
		System.out.println("Movie list :\n" + movieList);
	}

	static void testRemoveFavorites() throws FavoritesEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;

		try {
			favoritesDao.removeFavorites(2, 4);
			List<Movie> movieList = favoritesDao.getAllFavorites(2);
			System.out.println("Movie list after removed:\n" + movieList);
		} catch (Exception e) {
			throw new FavoritesEmptyException("Favorites is empty");
		}

	}

}
