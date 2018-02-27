<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<title>edit page</title>
</head>
<body>
	<header>
    	<h1>Edit book</h1>
    	<h3>login to get the necessary access rights</h3>
    	<div class="edit">
	    	<form action="SimpleServlet" method="post">
	    	<div class="bookStyle">
	    		<c:out value="${user_name}"/>
	    			
	    		<input type = "hidden" name="action"  value = "edit">
	    	    <input type="text" name="editName"  value="<c:out value="${book_value}"/>" required>
	    	    <input type="text" name="editAuthor"  value="<c:out value="${author_value}"/>" required>	    	   
	    	    <input type="date" name="editDate"   required>
	    	    <input type ="hidden" name="edit_book_id"  value = "${edit_book_id}" >	    	   
	    	    <input type="submit" value="edit_submit">
	    	    
	    	 </div>   
	   		 </form>
       
    </div>
        <p>*You can not use without registering.</p>

</header>
    
<section>
    <article>
       
    </article>
</section>
</body>
</html>