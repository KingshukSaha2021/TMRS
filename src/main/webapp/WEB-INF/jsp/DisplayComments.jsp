<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
		 %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Comments</title>
    
</head>
<body>
	<% 
		
		
		
	%>
    <div>
        <div>
            <h2>Comments</h2>
            <hr/>
            
             <div>List of comments for task <strong> </strong> </div>
             <br>
             <br>
             
             <div>
             	<label style="margin-left:100px; font-weight: bold;">Comment</label>
             	<label style="margin-left:200px;font-weight: bold;">Comment time</label>
             </div>
            
             <div>
             <c:forEach var="comment" items="${allComments}" varStatus="loop">
             	<input type="text" id="id${loop.index}" style="width: 70px;  border: none;" value="${task.id}" readonly/>
             	<input type="text" id="type${loop.index}" style="width: 172px; border: none;" value="${task.taskType}" readonly/>
             
             	<br>
             </c:forEach>
             </div>	
            
            <br>
            <br>
            <br>
            <br>
            <br>	
            <div><input type="submit" id="Add" style="margin-left : 500px; width: 70px;" value="Add" onclick="fnAdd()"/></div>	
            <br>
            <br>
            <div><input type="submit" id="Back" style="width: 70px;" value="Back" onclick="fnBack()"/></div>
        </div>
    </div>
    
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    
    <script type="text/javascript" >
    
    	function fnAdd(){
    		
    	}
    	
    	function fnBack() {
    		
    	}
    	
    </script>
    
</body>
</html>