<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<title>Second Page</title>
</head>
<body>
	<p>Admin page</p>
	
	<header>
    	<h1>First library</h1>
    	<h3>search book</h3>
    	<div class="subscribe">
    		<form action="SimpleServlet" method="post">
	    		<input type = "hidden" name="action"  value = "output">	    	    	    	   
	     	    <input type="submit" value="output ">	     	    
	   		 </form>
	   		 <form action="SimpleServlet" method="post">
	    		<input type = "hidden" name="action"  value = "search">
	    		 <input type="search" name="search" placeholder="search for name book" required>	    	    	    	   
	     	    <input type="submit" value="search ">	     	    
	   		 </form> 
	    	
	   		<form action="SimpleServlet" method="post">
	    		<input type = "hidden" name="action"  value = "add">
	    	    <input type="text" name="addName" placeholder="add name book" required>
	    	    <input type="text" name="addAuthor" placeholder="add name author" required>	    	   
	    	    <input type="date" name="publishDate" required>	    	   
	    	    	    	   
	     	    <input type="submit" value="add">
	   		 </form>      
    	</div>
        <p>*You can not use without registering.</p>
        
           <div class="book">
		       <p>список книг</p>
			    <form action="SimpleServlet" method="post">
			    	  
			    	<c:out value="${user_name}"></c:out>
			    	<c:forEach var="val" items="${listbook}">
			    	 
				    	<div class="bookStyle">
				    	<p>${val.getId()}</p>				    		 
				    	<p>${val}</p>	
				    <form action="SimpleServlet" method="post">
				    	<input type = "hidden" name="action"  value = "delete">
				    	<input type = "hidden" name="book_id"  value = "${val.getId()}" >
				    	<input type="submit"  value="delete">				    	
				    </form>
				    <form action="SimpleServlet" method="post">
				    	<input type = "hidden" name="action"  value = "ToEdit">
				    	<input type = "hidden" name="book_id2"  value = "${val.getId()}" >
				    	<input type="submit" onclick="editForm" value="ToEdit">
				    </form>
				    </div>
				    			    		
			    	</c:forEach>    			    	   
	     	    <div id="render"> 
	     	    	
	     	    </div>
	   		 
					</form>       
    	</div>

</header>
<!-- <script type="text/javascript">
function editForm(){
	var form=document.getElementById("${val.getId()}");
	form.style.display="inline-block"

	}
	function closeForm(){
	var form=document.getElementById("${val.getId()}");
	form.style.display="none";
	}
	
	function reqListener () {
  console.log(this.responseText);
}

var oReq = new XMLHttpRequest();
	oReq.addEventListener("load", reqListener);
	oReq.open("GET", "http://www.example.org/example.txt");
	oReq.send();
</script> -->
    

    		
       
</body>
</html>