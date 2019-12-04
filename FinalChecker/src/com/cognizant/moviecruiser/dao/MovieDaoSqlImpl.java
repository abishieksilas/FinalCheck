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

import com.cognizant.moviecruiser.model.Movie;

/**
 * @author Abishiek
 *
 */
public class MovieDaoSqlImpl implements MovieDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItemListAdmin()
	 */
	@Override
	public List<Movie> getMovieListAdmin() {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<Movie> movieList = new ArrayList<Movie>();
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;
		try {
			conn = ConnectionHandler.getConnection();
			if (conn != null) {
				preparedStatement = conn
						.prepareStatement("select * from movie");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					long id = resultSet.getLong(1);
					String title = resultSet.getString(2);
					long boxOffice = resultSet.getLong(3);
					String active = resultSet.getString(4);
					Date dateOfLaunch = resultSet.getDate(5);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);
					if (hasTeaser != null && hasTeaser.equals("Yes")) {
						hasTeaserFlag = true;
					} else {
						hasTeaserFlag = false;
					}
					if (active != null && active.equals("Yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					Movie movie = new Movie(id, title, boxOffice, activeFlag,
							dateOfLaunch, genre, hasTeaserFlag);
					/*
					 * emp1.setEmployee_id(empid); emp1.setName(name);
					 * emp1.setDate_of_birth(date); emp1.setSalary(sal);
					 */
					System.out.println(movie);
					movieList.add(movie);
				}
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
	
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<Movie> movieList = new ArrayList<Movie>();
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;
		try {
			conn = ConnectionHandler.getConnection();
			if (conn != null) {
				preparedStatement = conn
						.prepareStatement("select * from movie where mo_date_of_launch <= now() and mo_active='Yes'");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					long id = resultSet.getLong(1);
					String title = resultSet.getString(2);
					Date dateOfLaunch = resultSet.getDate(5);
					String active = resultSet.getString(4);
					long boxOffice = resultSet.getLong(3);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);
					if (hasTeaser != null && hasTeaser.equals("Yes")) {
						hasTeaserFlag = true;
					} else {
						hasTeaserFlag = false;
					}
					if (active != null && active.equals("Yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					Movie movie = new Movie(id, title, boxOffice, activeFlag,
							dateOfLaunch, genre, hasTeaserFlag);
					/*
					 * emp1.setEmployee_id(empid); emp1.setName(name);
					 * emp1.setDate_of_birth(date); emp1.setSalary(sal);
					 */
					System.out.println(movie);
					movieList.add(movie);
				}
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

		return movieList;

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
		Connection conn = ConnectionHandler.getConnection();
		String sql = "update movie set mo_title=?,mo_box_office=?,mo_active=?,mo_date_of_launch=?,mo_has_teaser=?,mo_genre=? where mo_id=?";
		try {
			if (conn != null) {
				PreparedStatement preparedStatement = conn
						.prepareStatement(sql);
				preparedStatement.setString(1, movie.getTitle());
				preparedStatement.setFloat(2, movie.getBoxOffice());
				if (movie.isActive()) {
					preparedStatement.setString(3, "Yes");
				} else {
					preparedStatement.setString(3, "No");
				}
				preparedStatement.setDate(4, new java.sql.Date(movie
						.getDateOfLaunch().getTime()));

				if (movie.isHasTeaser()) {
					preparedStatement.setString(5, "Yes");
				} else {
					preparedStatement.setString(5, "No");
				}
				preparedStatement.setString(6, movie.getGenre());
				preparedStatement.setLong(7, movie.getId());
				preparedStatement.executeUpdate();

			}
		} catch (SQLException sq) {
			sq.printStackTrace();
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
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItem(long)
	 */
	@Override
	public Movie getMovie(long movieId) {
		// TODO Auto-generated method stub

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		Movie movie = null;
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from movie where mo_id=?");
				preparedStatement.setLong(1, movieId);

				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, hasTeaserFlag;
				Date dateOfLaunch;
				while (resultSet.next()) {
					String title = resultSet.getString(2);
					long boxOffice = resultSet.getLong(3);
					String active = resultSet.getString(4);
					dateOfLaunch = resultSet.getDate(5);
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
							dateOfLaunch, genre, hasTeaserFlag);
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
		return movie;

	}

}
