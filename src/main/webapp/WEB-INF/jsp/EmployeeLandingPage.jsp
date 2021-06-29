<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
		import="java.util.StringTokenizer, java.util.List, java.util.ArrayList, com.persistent.hrms.tmrs.model.Users, com.persistent.hrms.tmrs.model.AllTaskModel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employee Home Page</title>
    
</head>
<body>
	<% 
		Users user = (Users)request.getAttribute("user");
	    List<AllTaskModel> allTasks = (ArrayList<AllTaskModel>) request.getAttribute("allTasks");
	    
		StringTokenizer st = new StringTokenizer(user.getUserName(),"@");
		String name = st.nextToken();
		
		
	%>
    <div>
        <div>
            <h2>Employee Home Page</h2>
            <hr/>
            
             <div>List of assigned tasks for <strong><%=name%></strong> </div>
             <br>
             <br>
             
             <div>
             	<label style="font-weight: bold;">Task Id</label>
             	<label style="margin-left:20px;font-weight: bold;">Task Type</label>
             	<label style="margin-left:110px;font-weight: bold;">Task Priority</label>
             	<label style="margin-left:20px;font-weight: bold;">Task Name</label>
             	<label style="margin-left:20px;font-weight: bold;">Task Description</label>
             	<label style="margin-left:20px;font-weight: bold;">Completion %</label>
             	<label style="margin-left:20px;font-weight: bold;">ETA</label>
             	<label style="margin-left:20px;font-weight: bold;">Creation Date</label>
             	<label style="margin-left:20px;font-weight: bold;">Blocked</label>
             	<label style="margin-left:20px;font-weight: bold;">Blocking Reason</label>
             </div>
            
             <div>
             <c:forEach var="task" items="${allTasks}" varStatus="loop">
             	<input type="text" id="id${loop.index}" style="width: 70px;  border: none;" value="${task.id}" readonly/>
             	<input type="text" id="type${loop.index}" style="width: 172px; border: none;" value="${task.taskType}" readonly/>
             	<input type="text" id="priority${loop.index}" style="width: 110px; border: none;" value="${task.priority}" readonly/>
             	<a href="/getComments" id="name${loop.index}" style="width: 150px;  border: none;">${task.taskName}</a>
             	<input type="text" id="description${loop.index}" style="margin-left: 10px; width: 130px; border: none;" value="${task.taskDescription}" readonly/> 
             	<input type="text" id="completion${loop.index}" style="width: 115px; border: none;" value="${task.completionPercentage}" readonly/> 
             	<input type="text" id="eta${loop.index}" style="width: 50px;  border: none;" value="${task.eta}" readonly/>
             	<input type="text" id="creationDate${loop.index}" style="width: 80px; border: none;" value="${task.creationDate}" readonly/>
             	<c:choose>
             	<c:when test="${task.blocked}">
             		<input type="checkbox" id="blocked${loop.index}" style="width: 120px;  border: none;" onclick="fnCheck(${loop.index})" checked/>
             	</c:when>
             	<c:otherwise>
             		<input type="checkbox" id="blocked${loop.index}" style="width: 120px;  border: none;" onclick="fnCheck(${loop.index})" />
             	</c:otherwise>
             	</c:choose>
             	<input type="text" id="blockingReason${loop.index}" style="width: 120px; border: none;" value="${task.blockingReason}" readonly/>
             	
             	<input type="button" style="width: 50px;" name="Edit${loop.index}" id="Edit${loop.index}" value="Edit" onclick="fnEdit(${loop.index})" />
             	<input type="button" style="margin-left:6px; width: 50px;" name="Save${loop.index}" id="Save${loop.index}" value="Save" onclick="fnSave(${loop.index})" />
             	<br>
             </c:forEach>
             </div>	
            
            <br>
            <br>
            <br>
            <br>
            <br>	
            <div><input type="submit" id="logoff" style="width: 70px; background-color: #66ccff;" value="Log Off" onclick="fnLogOff()"/></div>	
        </div>
    </div>
    
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    
    <script type="text/javascript" >
    
    	function fnEdit(index){
    		
    		$('#completion' + index).prop("readonly", false);
    		$('#completion' + index).css("border", "");
    	
    		var completionPercentage = "<input type=\"text\" id=\"completion" + index + "\" style=\"width: 111px;\" value=\"" + $('#completion' + index).val() + "\" /> ";  
    	
    		$('#completion' + index).replaceWith(completionPercentage);
    		
    		
    	}
    	
    	function fnSave(index){
    		if ($('#completion' + index).val() > 100){
    			alert("Error : completion percentage can not be more than 100%");
    			return;
    		}
    	}
    	
    	function fnCheck(index){
    		
    		if($('#blocked'+index).is(':checked')){
    			
    			$('#blockingReason' + index).prop("readonly", false);
        		$('#blockingReason' + index).css("border", "");
        		
        		var blockingReason = "<input type=\"text\" id=\"blockingReason" + index + "\" style=\"width: 115px;\" value=\"\" /> ";
        		
        		$('#blockingReason' + index).replaceWith(blockingReason);
    		}
    		else{
    			
    			$('#blockingReason' + index).prop("readonly", true);
        		$('#blockingReason' + index).css("border", "none");
        		
				var blockingReason = "<input type=\"text\" id=\"blockingReason" + index + "\" style=\"width: 120px;  border: none;\" value=\"\" readonly/> ";
        		
        		$('#blockingReason' + index).replaceWith(blockingReason);
    		}
    	}
    	
    	function fnLogOff(){
    		
    	}
    	
    </script>
    
</body>
</html>