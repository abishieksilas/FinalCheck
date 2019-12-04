/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

/**
 * @author Abishiek
 *
 */
public class FavoritesDaoSqlImpl implements FavoritesDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#addCartItem(long, long)
	 */
	@Override
	public void addFavorites(long userId, long movieId) {
		// TODO Auto-generated method stub

		Connection conn = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			if (conn != null) {

				preparedStatement = conn
						.prepareStatement("insert into favorites values(default,?,?)");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieId);
				System.out
						.println("userId: " + userId + " movieId: " + movieId);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#removeCartItem(long, long)
	 */
	@Override
	public void removeFavorites(long userId, long movieId) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement preparedStatement;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {
				preparedStatement = connection
						.prepareStatement("delete from favorites where fa_us_id=? and  fa_mo_id=?");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieId);
				preparedStatement.executeUpdate();
				System.out.println("Record deleted successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		// TODO Auto-generated method stub
		Connection connection = null;
		List<Movie> movieList = new ArrayList<Movie>();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;

		Movie movie = null;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {

				Favorites favorites = new Favorites(movieList, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("SELECT movie.mo_id, movie.mo_title,movie.mo_box_office ,movie.mo_active,movie.mo_date_of_launch,movie.mo_genre, movie.mo_has_teaser FROM movie ")
						.append("INNER JOIN favorites ON movie.mo_id = favorites.fa_mo_id WHERE favorites.fa_us_id = ?");
				// System.out.println("SqlString:" + sqlBuffer.toString());

				preparedStatement = connection.prepareStatement(sqlBuffer
						.toString());

				preparedStatement.setLong(1, userid);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					long movieId = resultSet.getLong(1);
					String title = resultSet.getString(2);
					long boxOffice = resultSet.getLong(3);
					String active = resultSet.getString(4);
					Date date_of_launch = resultSet.getDate(5);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);

					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (hasTeaser != null && hasTeaser.equals("Yes"))
						hasTeaserFlag = true;
					else
						hasTeaserFlag = false;
					movie = new Movie(movieId, title, boxOffice, activeFlag,
							date_of_launch, genre, hasTeaserFlag);
					movieList.add(movie);
					System.out.println("added movie:" + movie);
				}
				favorites.setMovieList(movieList);
				favorites.setTotal(getCountFavorites(userid, connection));
				System.out.println("Records fetched successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (movieList.size() == 0) {
			throw new FavoritesEmptyException("Favorites is Empty");
		}

		return movieList;

	}

	private long getCountFavorites(long userId, Connection conn) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		long total = 0;
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			if (conn != null) {
				Favorites favorites = new Favorites(movieList, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("SELECT COUNT(movie.mo_id) FROM movie INNER JOIN favorites ON movie.mo_id = favorites.fa_mo_id ")
						.append("WHERE favorites.fa_us_id = ?");
				// System.out.println("SqlString:" + sqlBuffer.toString());

				preparedStatement = conn.prepareStatement(sqlBuffer.toString());
				preparedStatement.setLong(1, userId);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					total = resultSet.getLong(1);
				}
				System.out.println("Count has changed");
			}
		} catch (SQLException sq) {
			sq.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return total;
	}
}
