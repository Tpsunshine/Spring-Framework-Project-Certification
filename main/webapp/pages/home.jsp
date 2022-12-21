<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
#wrapper {
	margin: 100px auto;
	width: 550px;
	background: linear-gradient(45deg, black, orangered, black);
	color: white;
	padding: 10px;
	border-radius: 10px;
	box-shadow: 0 0 10px black;
}

#header {
	height: 80px;
	width: 100%;
	background: linear-gradient(45deg, black, orangered, black);
	color: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px black;
}

table {
	font-size: 18px;
	width: 97%;
}

input {
	font-size: 18px;
}

tr {
	height: 40px;
}

input[type=submit] {
	margin-top: 35px;
	background-color: transparent;
	border: 1px solid white;
	padding: 3px 25px;
	border-radius: 20px;
	color: white;
}

input[type=submit]:hover {
	background-color: white;
	color: black;
	box-shadow: 0 0 10px white;
}
</style>
<title>Home</title>
</head>
<body>
	<div id="header">
		<a href=http://localhost:9100/application/account/home/${partyId}>
			<img src="logo_fast_reviews2.jpg" alt="Fast reviews" />
		</a>
		<div align="right">

			<a href=http://localhost:9100/application/account/home/${partyId}>Home</a>
			<a href=http://localhost:9100/application/account/logout/${partyId}>Logout</a>
		</div>
	</div>
	<h3>${message}</h3>
	<br>

	<div id="wrapper">
		<h3>
			Want to Add your review &nbsp;&nbsp;&nbsp;&nbsp;<a
				href="http://localhost:9100/application/${party.partyId}/books">
				Click here</a>
		</h3>

		<h2>Most recent review on this site:</h2>
		<table>
			<tbody>
				<c:forEach items="${reviewDetails}" var="reviewDetails">
					<tr>
						<td>${reviewDetails.review.comment}<br>
							${reviewDetails.party.firstName} on
							${reviewDetails.book.bookName}<br>
						<br>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<%-- <div id="wrapper">

		<div align="left">
			<p>
				Your Reviews:<br>
			</p>
		</div>
		<table>
			<tbody>
				<c:forEach items="${reviewDetailsParty}" var="reviewDetails">
					<tr>
						<td>${reviewDetails.review.comment}<br> on
							${reviewDetails.book.bookName}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div> --%>

	<div id="header" align="center">@ 2020 My Name</div>
</body>
</html>