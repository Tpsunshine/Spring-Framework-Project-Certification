<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Recent Review</title>
</head>
<body>
	<div id="header">
		<a href=http://localhost:9100/application/account/home/${partyId}>
			<img src="logo_fast_reviews2.jpg" alt="logo" />
		</a>
		<div align="right">

			<a href=http://localhost:9100/application/account/home/${partyId}>Home</a>
			<a href=http://localhost:9100/application/account/logout?${partyId}>Logout</a>
		</div>
	</div>
	<div id="wrapper">

		<form:form id="search"
			action="http://localhost:9100/application/searchBook/${search}"
			method="get">
			<table>
				<tr>
					<td><label id="search"> Search other Book</label></td>
				</tr>
				<tr>
					<td><input required="required" size="50" id="search"
						placeholder="search here" type="text" /></td>
				</tr>
				<tr>
					<td colspan=2 align=left><input type=submit value="Search" />
					</td>
				</tr>
			</table>
		</form:form>
	</div>
	<div id="wrapper">
		<p>
		<h3>Last review on</h3>
		<h2>${reviewDetails.book.bookName}
			:<br>
		</h2>
		<h3>
			<p>${reviewDetails.review.comment}<br>
				<br>
			</p>
		</h3>


		<form:form id="addReview"
			action="http://localhost:9100/application/reviews/${partyId}/${reviewDetails.book.bookId}/addReview"
			method="post" modelAttribute="review">
   Add more reviews :
    <table>
				<tr>
					<td><label for="comment"> </label></td>
				</tr>
				<tr>
					<td><form:input path="comment" required="required" size="100"
							id="comment" value="Write here" /></td>
				</tr>
				<tr>
					<td colspan=2 align=left><input type=submit
						value="Add your Review" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<div id="header" align="center">@ 2020 My Name</div>
</body>
</html>