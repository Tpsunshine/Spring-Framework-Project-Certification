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
<title>Insert title here</title>
</head>
<body>
<div id = "header">
<a href=index.html>
<img src = #></a>
<div align="right" padding="20px";>
<a href= "http://localhost:9100/application/default"/>Home</a>
<a href= "http://localhost:9100/application/account/signin">Login</a>
<a href= "http://localhost:9100/application/account/signup">SignUp</a>
</div>
</div>
	<div id="wrapper">
	<form:form id = "login" action="/application/account/login?userId=${userId}&password=${password}" method = "GET">
	 <table>
     <tr>
       <td>
         <label for="fname">User Number</label>
       </td>
       <td>  
         <input type = "text" name = "userId" required placeholder="username"> 
       </td>
     </tr>
     
     <tr>
       <td>
         <label for="fname">Password</label>
       </td>
       <td>  
         <input type = "password" name = "password" required placeholder="password"> 
       </td>
     </tr>
     <tr>
 	   <td colspan=2 align=center>
 	    <input type=submit value="Proceed" onclick=""/>
 	  </td> 
</tr>
</table>
</form:form>
</div>
<div id="header" align="center">
@ 2021 My Name
</div>
<!-- <script>
const results = document.getElementById('results')
new Url(window.location.search).forEach((value, name) =>{
	results.a
})
</script> -->

</body>
</html>