package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.acess.EntityManagerClass;
import br.com.model.Monitor;

public class MonitorDAO {
	
	private static EntityManagerClass instance;
	
	protected EntityManager entityManager;
	
	
	public static EntityManagerClass getInstance() {
		if (instance == null) {
			instance = new EntityManagerClass();
		}
		return instance;
	}
	
	public MonitorDAO() {
		entityManager = EntityManagerClass.getEntityManager();
	}
	
	public Monitor getbyId(Long id) {
		return  this.entityManager.find(Monitor.class,id);
	}
	
	public List<Monitor> list(){
		return this.entityManager.createNamedQuery("FROM " + Monitor.class.getName()).getResultList();
	}
	
	public void add(Monitor monitor) {
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(monitor);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	
	public void update(Monitor monitor) {
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(monitor);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
}
