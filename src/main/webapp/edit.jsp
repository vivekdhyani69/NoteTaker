<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.helper.*,org.hibernate.*,com.entities.*" %>
    
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
<h1 style="text-shadow: 2px 2px red;" class="text-center">Edit Your Note</h1>
<br>
<%

//get krli id ki value
int noteId=Integer.parseInt(request.getParameter("note_id").trim());
//ab hume note ka object banana hai

	
		Session s=FactoryProvider.getFactory().openSession();
	
		
		Note note=(Note)s.get(Note.class,noteId);
		
%>
<!-- //Now we makes a edit's form -->
  
  <!-- //ye yaha action me update Servlet islia dala hai bcz ye servlet he
  req and resp kr k db me update krega -->
  
   <form action="UpdateServlet" method="post">
   
   <!-- //ye hidden valid field servlet pe use krne k lia bnayi hai vesa
   yaha koi need nhi tbhi hidden kr rkha hai -->
   <!-- ye value ki jo value ayegi get hoke vo name me save hogi -->
   
   <input value="<%=note.getId() %>" name="noteId" type="hidden" />
  <div class="form-group">
    <label for="title">Note Title</label>
    
    <input type="text" name="title"
    class="form-control" required
     id="title" 
     aria-describedby="emailHelp" 
     placeholder="Enter here" 
     value="<%=note.getTitle()%>" />
    
     <!-- ab is input ki value me already Title get krke value save kre rkhege --> 
  </div>
  
  <div class="form-group">
    <label for="content">Note Content</label>
    
    <textarea required name="content"
    id="content"
    placeholder="Enter your content here" class="form-control"
    style="height: 300px;"> <%=note.getContent()%></textarea>
  </div>

 <div class="container text-center">
  <button type="submit" class="btn btn-success">Save your note</button>
 </div>
</form>
</div>
</body>
</html>