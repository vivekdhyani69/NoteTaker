package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
///Post vala method he chlayege bcz form me method me post de rkha hai
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
///Now we fetch all value of form in a servlet
		
		try {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
///That is Hibernate k note class ka object iss class me hum save krege data 
//jo be fetch kri hai jsp pages se and fr db me save krayege
		Note note=new Note(title,content,new Date());
		 
		//Phele note me content dala construtor ki help se and ab note ko get kara rahe jo chaiye
		//System.out.println(note.getId() +":"+ note.getTitle());//Print console
		
		//Now hume ye title and content ye sara data db me save krana hai 
	 ///use hibernate coding
		Session s=FactoryProvider.getFactory().openSession();//Factory provider vali class use kri
		
		Transaction tx=s.beginTransaction();//Physically chngd in db
	    s.save(note);//ye likhte he db me saved
	
	    tx.commit();
		s.close();
		///yaha tk db me save ho gaya
		response.setContentType("text/html");
		//Ab servlet k page(web) pe print krane k lia used
		PrintWriter out=response.getWriter();
		out.println("<h1 style='text-align:center';>Note is added successfully</h1>");
		out.println("<h1  style='text-align:center';><a href='all_notes.jsp'>View All Notes </a>"
				+ "</h1>");
		
		}catch(Exception e) {
			e.printStackTrace();
				
		}
		
	}

}
