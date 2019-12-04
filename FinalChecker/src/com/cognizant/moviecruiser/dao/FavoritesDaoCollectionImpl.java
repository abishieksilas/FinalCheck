/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

/**
 * @author Abishiek
 *
 */
public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {

		if (userFavorites == null) {
			userFavorites = new HashMap<Long, Favorites>();
			try {

				List<Movie> movieList = new ArrayList<Movie>();

				Favorites favorites = new Favorites(movieList, 0);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#addCartItem(long, long)
	 */
	@Override
	public void addFavorites(long userid, long movieId) {
		// TODO Auto-generated method stub
		List<Movie> movieList;
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		MovieDao movieDao = movieDaoCollectionImpl;
		// MenuItem mitem = menuItemDao.getMenuItem(menuItemId);
		Long userId = new Long(userid);
		Movie movie = movieDao.getMovie(movieId);
		if (userFavorites.containsKey(userId)) {
			Favorites favorites = userFavorites.get(userId);
			movieList = favorites.getMovieList();
			movieList.add(movie);
			favorites.setMovieList(movieList);
			// cart.setTotal(cart.getTotal() + menuItem.getPrice());
			userFavorites.put(userId, favorites);

		} else {
			movieList = new CopyOnWriteArrayList<Movie>();
			movieList.add(movie);

			Favorites favorites = new Favorites(movieList, movie.getBoxOffice());
			userFavorites.put(userId, favorites);

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#getAllCartItems(long)
	 */
	@Override
	public List<Movie> getAllFavorites(long userid)
			throws FavoritesEmptyException {

		Favorites favorites = userFavorites.get(new Long(userid));
		List<Movie> movieList = favorites.getMovieList();
		if (movieList == null || movieList.size() == 0) {
			throw new FavoritesEmptyException("Cart is empty");
		}
		long total = 0;
		for (Movie movie : movieList) {
			total = total + movie.getBoxOffice();

		}
		favorites.setTotal(total);

		// TODO Auto-generated method stub
		return movieList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#removeCartItem(long, long)
	 */
	@Override
	public void removeFavorites(long userId, long movieId) {
		// TODO Auto-generated method stub

		if (userFavorites.containsKey(userId)) {
			Favorites favorites = userFavorites.get(userId);
			List<Movie> movieList = favorites.getMovieList();
			for (Movie movie : movieList) {
				if (movie.getId() == movieId) {
					movieList.remove(movie);
				}
			}
			favorites.setMovieList(movieList);
			userFavorites.put(userId, favorites);

		}
	}

}
