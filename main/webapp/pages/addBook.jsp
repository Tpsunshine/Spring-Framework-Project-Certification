<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
#wrapper{
	margin:100px auto;	
	width:550px;
	background:linear-gradient(45deg,black,orangered,black);
	color:white;
	padding:10px;
	border-radius:10px;
	box-shadow:0 0 10px black;
}
#header{
	height:80px;
	width:100%;
	background:linear-gradient(45deg,black,orangered,black);
	color:white;
	padding:20px;
	border-radius:10px;
	box-shadow:0 0 10px black;
}
table{
	font-size:18px;
	width:97%;
}
input{
 font-size:18px;
}
tr{
 height:40px;
}
input[type=submit]{
  margin-top:35px;
  background-color:transparent;
  border:1px solid white;
  padding:3px 25px;
  border-radius:20px;
  color:white;
}
input[type=submit]:hover{  
  background-color:white;
  color:black;
  box-shadow:0 0 10px white;
}
</style>
<title>Add Book</title>
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
<div id="wrapper">
	<h2> Add New Book</h2>
	<form:form id = "addBook" action="http://localhost:9100/application/${partyId}/addBook" method="post" modelAttribute="book" >
    <table>
     <tr>
       <td>
         <label for="bname">Book Name</label>
       </td>
       <td>  
         <form:input path="bookName" required="required" size="25" id="bname"/>
       </td>
     </tr>

     <tr>
       <td>
         <label for="publishers">Publishers</label>
       </td>
       <td>  
         <form:input path="publishers" required="required"  size="25" id="publishers"/>
       </td>
     </tr>    
      <tr>
       <td>
         <label for="authName">Author Name</label>
       </td>
       <td>  
         <form:input path="author" required="required" size="25" id="authName"/>
       </td>
     </tr>

     <tr>
       <td>
         <label for="department">Genre</label>
       </td>
       <td>  
         <form:input path="departments" required="required"  size="25" id="department" placeholder="eg: sports,fiction,thriller"/>
       </td>
     </tr>     
 		
 		<tr>
       <td>
         <label for="tagLine1">Tag Line 1</label>
       </td>
       <td>  
         <form:input path="tag1" size="25" id="tagLine1"/>
       </td>
     </tr>
     <tr>
       <td>
         <label for="tagLine2">Tag Line 2</label>
       </td>
       <td>  
         <form:input path="tag2" size="25" id="tagLine2"/>
       </td>
     </tr>
<tr>
       <td>
         <label for="tagLine3">Tag Line 3</label>
       </td>
       <td>  
         <form:input path="tag3" size="25" id="tagLine3"/>
       </td>
     </tr>
 	 <tr>
 	   <td colspan=2 align=center>
 	    <input type=submit value="Add New Book"/>
 	  </td> 
 	 <TH>
 	 </tr>
    </table>
   </form:form>  
	</div>
	<div id="header"  align="center">
@ 2020 My Name
</div>
</body>
</html>