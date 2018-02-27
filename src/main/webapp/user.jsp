<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/User.css" />
<title>Insert title here</title>
</head>
<body>
	<p>User page</p>
	
	<header>
    	<h1>First library</h1>
    	<h3>search book</h3>
    	<div class="subscribe">
	    	<form action="SimpleServlet" method="post">
	    		<input type = "hidden" name="action"  value = "search">
	    	    <input type="text" name="search" placeholder="enter book name" required>	    	   
	     	    <input type="submit" value="search">
	   		 </form>       
    	</div>
        <p>*You can not use without registering.</p>

</header>
    

    		
       <div class="book">
		       <p>список книг</p>
			    	<form action="SimpleServlet" method="post">
			    		<p><c:out value="${book_name}"/></p>
			    		<c:forEach var="val" items="${listbook}">
			    			<p>${val}</p>
			    		</c:forEach>
			
					<h3><c:out value="${messege}"/></h3> 
					</form>       
    	</div>
    

</body>
</html>