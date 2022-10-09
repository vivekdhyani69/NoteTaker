package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			//ab yaha get krle title and content ko
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			int noteId=Integer.parseInt(request.getParameter("noteId").trim());
			
			//and ab humne yhi cheeje db me se chnge krni hai..create session 
			
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();//Physically chngable
		 //1.load krege data
			//ab hum db se uperli noteId ka object nikalege
			Note note=s.get(Note.class,noteId);//hmara note ka object persistence stage pe hai ab hum easily edit be kr skte hai
			
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());//live date ayegi jb edit krege
			
			tx.commit();
		    s.close();
		    //jesa he edit ho jata hai apne main page pe redirect response kara do
		    	response.sendRedirect("all_notes_jsp");
	
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	
	
	}

}
