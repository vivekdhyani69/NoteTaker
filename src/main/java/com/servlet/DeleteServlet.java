package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//servlet bs database se uski sari va;lue get kr skta hai getRequest and post
			//ki help se....esa he ab yaha particular note_id ki value layega and
			//integer me convert kr dega..
			
			int noteId=Integer.parseInt(request.getParameter("note_id").trim());
		
//ab hume delete krna hibernate ki help se then makes session iski help se kuch na hoga hiber me
			
		Session s=FactoryProvider.getFactory().openSession();
		Transaction tx=s.beginTransaction();//Physically Transactions
		//ab delete se phle lode class	db se note nikal k de dega
		Note note=(Note)s.get(Note.class,noteId);
		s.delete(note);//abi db se delete
		tx.commit();
		s.close();//and ye session se be delete 
		
		//In the end delete hone k baad usi page me response redirect kara dena hai
		response.sendRedirect("all_notes.jsp");
		
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}


}
