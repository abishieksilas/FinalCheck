<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cognizant.moviecruiser.model.Movie"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<title>Movie List Customers</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<header class="header container-fluid">
		<h1 class="header-itemleft">
			Movie Cruiser
			</h1>
				<img src="images/images.jpg"> <a class="header-itemright"
					href="ShowFavoritesServlet">Favorites</a> <a
					class="header-itemright" href="ShowMovieListCustomerServlet">Movies</a>
	</header>
	<br>
	<section class="body-main">
		<h2>Movies</h2>
		<c:if test="${addFavoritesStatus }">
		<h2 style="color:#00cc88">Item Added To Favorites Successfully</h2></c:if>
		<table style="width:100%;" id="movieitems">
			<tr>
				<th class="th-text-align-left">Title</th>
				<th class="td-text-align-right">Box Office</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach var="item" items="${customerMovieList}">
			<tr>
				<td class="td-text-align-left">${item.title}</td>
				<td class="td-text-align-right"><fmt:setLocale value="en_US"/><fmt:formatNumber type="currency" value="${item.boxOffice}"/></td>
				<td>${item.genre}</td>
				<td>${item.hasTeaser? 'Yes' : 'No'}</td>
				<td><a href="AddToFavoritesServlet?movieId=${item.id}">Add to
						Favorite</a></td>
			</tr>
			</c:forEach>
			 
		</table>
	</section>
	<footer>Copyright©2019</footer>

</body>
</html>