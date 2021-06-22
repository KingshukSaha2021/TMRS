<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Task Management & Reporting System</title>
    
<script type="text/javascript">
	function displaySelect(){
		
		alert(document.getElementById("userType").value);
	}
	
	function isValidUser(validUser){
		if(validUser == false){
			alert('Not a valid credential!');
		}
	}

</script>
</head>
<body onload="isValidUser(${validUser})">
    <div>
        <div>
            <h2>Task Management & Reporting System</h2>
            <hr/>
            <br>
            <br>
            <br>
            <br>
          	<form:form action="login-user" modelAttribute="users" method="post">
	            <label style="margin-left: 200px;">User Name : <label/>
	            <form:input type="text" size="40" style="margin-left: 25px;" id="userName" path="userName"/>
	            <br> <br>
	            <label style="margin-left: 200px;">Password : <label/>
	            <form:input type="password" size="40" style="margin-left: 35px;" id="password" path="password"/>
	            <br> <br>
	            <label style="margin-left: 200px;">User Type : <label/>
	            
	            <select name="userType" id="userType" style="margin-left: 32px; width: 120px;" path="userType" onchange="displaySelect()">
				  <c:forEach var="utype" items="${UserTypes}">
				  	<option id="userType${utype.id}" value="${utype.id}">${utype.type}</option>
				  </c:forEach>
				</select>
	            
	            <br>
	           	<br>
	           	<br>
	             
	            <button type="submit" style="margin-left: 545px; width: 70px; background-color: #66ccff;">Login</button>
	            
            
           	</form:form>
        </div>
    </div>
</body>
</html>