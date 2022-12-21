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
<title>SIGN UP</title>
</head>
<body>
 <div id="wrapper">
  <h2 style="text-align:center">SIGN UP/ REGISTRATION</h2>
  <form:form id = "registration" action="http://localhost:9100/application/account/registration" method="post" modelAttribute="party" >
    <table>
     <tr>
       <td>
         <label for="fname">First Name</label>
       </td>
       <td>  
         <form:input path="firstName" required="required" size="25" id="fname"/>
       </td>
     </tr>

     <tr>
       <td>
         <label for="lname">Last Name</label>
       </td>
       <td>  
         <form:input path="lastName" required="required"  size="25" id="lname"/>
       </td>
     </tr>     
 		
 	
 	 <tr>
       <td>
         <label for="phoneNo">Phone Number</label>
       </td>
       <td>  
         <form:input path="mobileNo" size="10" id="phoneNo" type="number" />
         
       </td>
     </tr>
     
     <tr>
       <td>
         <label for="email">E-mail Id</label>
       </td>
       <td>  
         <form:input path="email" size="25" id="email"/>
       </td>
     </tr>
    <tr>
            <td>Password</td>
            <td><input path="password" type="text" name = "password" id="password"/></td>
        </tr>
    
 	 <tr>
 	   <td colspan=2 align=center>
 	    <input type=submit value="Proceed" />
 	  </td> 
 	 <TH>
 	 
 <!-- 	 <script type="text/javascript">  
    $('#Proceed').click(function () {  
        var url =  $("#registration");  
        var name = $("#password").val();  
        //var address = $("#Address").val();  
       $.post(url, { password: name}, function (data) {  
            $("#msg").html(data);  
        });  
    })  
	</script>   -->
  	  <td> <a href="/registration?password=$<password>">Submit</a> 
  	  
 	  <!-- <td><a href="/registration?password=password ">Submit</a> -->
 	 </tr>
    </table>
   </form:form>  
  </div>
  <hr>
  <hr>
  <%-- 	<table id="resultTable">
		<caption>Student Details</caption>
		<tr>
			<td>Student ID</td>
			<td>${student.studentId}</td>
		</tr>
		<tr>
			<td>Student Name</td>
			<td>${student.studentName}</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>${student.studentGender}</td>
		</tr>

		<tr>
			<td>Course</td>
			<td>${student.courseName}</td>
		</tr>

		<tr>
			<td>Preferred Timings</td>			
			<td>${selectedTimings}</td>
		</tr>
	</table> --%>
 </body>
</html>
