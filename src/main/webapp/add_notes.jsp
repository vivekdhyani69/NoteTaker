<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <%@include file="all_js_css.jsp" %>
</head>
<body>
<div class="container">
 	
   <%@include file="Navbar.jsp" %>
   <br>
   <h1>Fill the details</h1>
   
   <!-- This is add form -->
   
   <form action="SaveNoteServlet" method="post">
  <div class="form-group">
    <label for="title">Note Title</label>
    
    <input type="text" name="title"
    class="form-control" required
     id="title" 
     aria-describedby="emailHelp" 
     placeholder="Enter here"/>
  </div>
  
  <div class="form-group">
    <label for="content">Note Content</label>
    
    <textarea required name="content"
    id="content"
    placeholder="Enter your content here" class="form-control"
    style="height: 300px;"></textarea>
  </div>

 <div class="container text-center">
  <button type="submit" class="btn btn-primary">Add</button>
 </div>
</form>
   </div>
   
</body>
</html>