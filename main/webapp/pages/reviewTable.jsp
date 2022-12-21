<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="form"%>
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
<title>Review Details</title>

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

<form:form id = "search" action="http://localhost:9100/application/searchBook?search=${search}" method="get" >
    <table>
     <tr>
       <td>
         <label id="search"> search</label>
       </td>
       </tr>
       <tr>
       <td>  
        <input path="search" required="required" size="50" name="search" placeholder="search here" type="text"/>
       </td>
     </tr>
     <tr>
 	   <td colspan=2 align=center>
 	    <input type="submit" value="Search"/>
 	  </td> 
</tr>
     </table>
     </form:form>
</div>
	<h2>
		Reviews on <b>${book.bookName}</b> by <b> ${book.author}</b>
	</h2>
	<input type=button value="Add Review" />
	<a
		href="http://localhost:9100/application/reviews/addReview/${reviewDetails.book.bookId}">Add
		Review</a>
	<form:form id="login" action="/application/account/login?userId="
		method="GET">
		<div id="review">
			<table border=1>

				<tbody>
					<c:forEach items="${reviewDetails}" var="reviewDetails">
						<tr>
							<td>${reviewDetails.party.firstName}says :</td>
							<td>${reviewDetails.review.comment}</td>
							<td>
								<!-- <button id = "likebtn">
						<i class = "fa fa-thumbs-up"></i></button>
						<input type = "number" id = "input1" value=${reviewDettails.review.likes}></td> -->
								<a
								href="/application/reviews?reviewId=${reviewDetails.review.reviewId}">${reviewDetails.review.likes}
									likes</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form:form>
	<div id="header" align="center">@ 2020 My Name</div>
</body>
</html>