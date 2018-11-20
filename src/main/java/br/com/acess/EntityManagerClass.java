package br.com.acess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerClass {
	
	private static EntityManagerFactory emf;
	 
    public static EntityManager getEntityManager() {
         if (emf == null) {
            emf = Persistence.createEntityManagerFactory("agenda");
         }
         return emf.createEntityManager();
    }
}
