<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cognizant.moviecruiser.model.Movie"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="style/style.css">
<title>Movie List Admin</title>
</head>
<body>
	<header class="header container-fluid">
		<h1 class="header-itemleft">Movie Cruiser</h1>
		<img src="images/images.jpg"> <a class="header-itemright"
			href="ShowMovieListAdminServlet">Movies</a>
	</header>
	<br>
	<section class="body-main">
		<h2>Movies</h2>
		<table>
			<tr>
				<th class="th-text-align-left">Title</th>
				<th class="th-text-align-right">Box Office</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach var="item" items="${adminMovieList}">
				<tr>
					<td class="td-text-align-left">${item.title}</td>
					<td class="td-text-align-right"><fmt:setLocale value="en_US" />
						<fmt:formatNumber type="currency" value="${item.boxOffice}" /></td>
					<td>${item.active?'Yes' : 'No'}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${item.dateOfLaunch}" /></td>
					<td>${item.genre}</td>
					<td>${item.hasTeaser?'Yes' : 'No'}</td>
					<td><a href="ShowEditMovieServlet?movieId=${item.id}">Edit</a></td>
				</tr>
			</c:forEach>

		</table>
	</section>
	<footer>Copyright©2019</footer>

</body>
</html>