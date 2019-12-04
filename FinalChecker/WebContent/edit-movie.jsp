<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cognizant.moviecruiser.model.Movie"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html>
<head>
<title>Edit Movie</title>
<link rel="stylesheet" href="style/style.css">
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="style/editmovie.css">

</head>
<body>
<c:set var="genre" value="Science Fiction,Superhero,Romance" scope="application"/>
<c:set var="selected" value="${movie.genre}" scope="application"/>

	<header class="header container-fluid">
		<h1 class="header-itemleft">Movie Cruiser</h1>
		<img src="images/images.jpg"> <a class="header-itemright"
			href="ShowMovieListAdminServlet">Movies</a>
	</header>
	<section class="body-main">
		<h1 style="padding-left:1px;">
			Edit Movie
			</h1>
				<form name="editMovieForm" action="EditMovieServlet"
					method="post" onsubmit="return validateMovieForm()">
					<table style="width: 100%">
						<tr>
							<th colspan="4"><label for="mname">Title</label></th>
						</tr>
						<tr>
							<td colspan="4"><input type="text" id="mname" name="title"
								style="width: 83%; height: 20px" value="${fn:trim(movie.title)}"></td>
						</tr>
						
						<tr>
							<th style="padding-top:25px"><label for="boxoffice">Gross ($)</label></th>
							<th style="padding-top:25px"><label for="active">Active</label></th>
							<th style="padding-top:25px"><label for="dateOfLaunch">Date of Launch</label></th>
							<th style="padding-top:25px"><label for="genre">Genre</label></th>
						</tr>
						<tr>
					<td><input type="text" name="boxOffice" id="mprice"
						value="${movie.boxOffice}"></td>
					<c:choose>
						<c:when test="${movie.active}">
							<td><input type="radio" id="active" name="active"
								value="yes" style="font-size: 20px" checked>Yes <input
								type="radio" id="active" name="active" value="no"
								style="font-size: 20px">No</td>
						</c:when>
						<c:otherwise>
							<td><input type="radio" id="active" name="active"
								value="yes" style="font-size: 20px">Yes <input
								type="radio" id="active" name="active" value="no"
								style="font-size: 20px" checked>No</td>
						</c:otherwise>
					</c:choose>


					<td><input type="date" name="dateOfLaunch" id="mdate" value=<fmt:formatDate pattern="dd/MM/yyyy" value="${movie.dateOfLaunch}"/>></td>
							
							<td><select name="genre">
									<option value="${selected}" selected>${selected}</option>
									<c:forEach items="${genre}" var="Genre">
										<c:if test="${Genre!=selected}">
											<option value="${Genre}">${Genre}</option>
										</c:if>
									</c:forEach>
							</select> </td>
						</tr>
						
						<tr>
							<td style="padding-top:25px"><input type="checkbox" name="hasTeaser" value="${movie.hasTeaser}"<c:if test="${movie.hasTeaser}">checked="checked"</c:if>/>
								<label>Has Teaser</label></td>
						</tr>
						
						<tr>
							<td style="padding-top:25px"><input type="submit" class="button" name="submit"
								value="Save"></td>
						</tr>
					</table>
					<input type="hidden" name="movieId" value="${movie.id}">
				</form>
	</section>
	<footer>Copyright©2019</footer>

</body>
</html>