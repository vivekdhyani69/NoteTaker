<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes: Note-Taker</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>

<div class="container">
  <%@include file="Navbar.jsp" %>
  <br>
  <h1>All Notes:</h1>
   
  
  
  <div class="row">
  <div class="col-12">
  
    <%
   Session s=FactoryProvider.getFactory().openSession();
  Query q= s.createQuery("from Note");//ye ek ek kr k sare notes de dega
  List<Note> list=q.list();//and ab vo sare not yaha aa gye
  
  for(Note note : list){
	  
	  %>
	  <div class="card mt-3 " >
  <img class="card-img-top m-4 mx-auto" style="max-width:100px" src="img/notepad.png" alt="Card image cap">
  <div class="card-body px-5">
    <h5 class="card-title"><%=note.getTitle() %></h5>
    <p class="card-text">
    <%=note.getContent() %>
    </p>
<div class="container text-center mt-2">

<!-- Humne delete button dabate he delete krana hai db se(tbhi front se delete hoga)
then humne yaha skim lgayi hai.....makes new servlet ku ki vhi db and frontend se
interact krata hai then yaha href me note_id variable me note.getId be pass krdi hai
 --> 
    <a href="DeleteServlet?note_id=<%=note.getId()%>" class="btn btn-danger">Delete</a>
    
 <!-- //ye href me question mark lgane se hum particular 
 //post ki id get kara rahe hai and iss href vale page ko b bj rahe hai    -->
 
    <a href="edit.jsp?note_id=<%=note.getId() %>" class="btn btn-primary">Update</a>
<!-- live date dikhane k lia jo b add kra hai note uska -->
<p class="text-primary"><%=note.getAddedDate() %></p>
</div>    
  </div>
</div>
  
  <%
  }
  %>
  </div>
  
  </div>
  

</div>
</body>
</html>