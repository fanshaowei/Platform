package cn.com.chengzi.framework.common.generic;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDao <T, PK extends Serializable>{
	
   Class<T> entity;	
	
   @Autowired
   private SessionFactory hibernateSessionFactory;
   
   public Session getSession(){
	   return hibernateSessionFactory.getCurrentSession();
   }
   
   public Session getNewSession(){
	   return hibernateSessionFactory.openSession();
   }
   
   public void flush() {
       getSession().flush();
   }

   public void clear() {
       getSession().clear();             
   }
}
