package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class FactoryProvider {

	///Now ye static variable hum only static function me use kr skte hai
	public static SessionFactory factory;
	
	//Yaha iss method ko static islia taki hume call na krne pde
	 public static SessionFactory getFactory() {
		 
		 if(factory==null) {//Jb factory me kuch nhi hai iss case crete kr k stored
			 
			 //ye new factoy bna dega
			 factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			 
			 
		 }
		 
		 return factory;
		 
	 }
	 
	 //Factory agr bni hai to close krne ka method
	 public void closeFactory() {
		 if(factory.isOpen()) {
			 factory.close();
		 }
	 }
	
}
