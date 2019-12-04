package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoSqlImpl;
import com.cognizant.moviecruiser.model.Movie;

/**
 * Servlet implementation class EditMenuItemServlet
 */
@WebServlet("/EditMovieServlet")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = movieDaoSqlImpl;
		// List<MenuItem> menuItemList=menuItemDao.getMenuItemListAdmin();

		long id = Long.parseLong(request.getParameter("movieId"));
		String title = request.getParameter("title");
		long boxOffice = Long.parseLong(request.getParameter("boxOffice"));
		String active = request.getParameter("active");
		boolean activeFlag;
		if (active.equals("yes")) {
			activeFlag = true;
		} else {
			activeFlag = false;
		}
		String genre = request.getParameter("genre");
		boolean hasTeaser = request.getParameter("hasTeaser") != null;
		String dol = request.getParameter("dateOfLaunch");
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setBoxOffice(boxOffice);
		movie.setActive(activeFlag);
		movie.setGenre(genre);
		movie.setHasTeaser(hasTeaser);

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dateOfLaunch = sdf.parse(dol);
			movie.setDateOfLaunch(dateOfLaunch);

			movieDao.modifyMovie(movie);
			// request.setAttribute("menuItem", menuItem);
			response.sendRedirect("edit-movie-status.jsp");
			// request.getRequestDispatcher("display-employee.jsp").forward(request,
			// response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(movie);
	}

}
