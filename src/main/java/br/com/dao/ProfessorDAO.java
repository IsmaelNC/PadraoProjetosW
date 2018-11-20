package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.acess.EntityManagerClass;
import br.com.model.Professor;

public class ProfessorDAO {
	
	private static EntityManagerClass instance;
	
	protected EntityManager entityManager;
	
	
	public static EntityManagerClass getInstance() {
		if (instance == null) {
			instance = new EntityManagerClass();
		}
		return instance;
	}
	
	public ProfessorDAO() {
		entityManager = EntityManagerClass.getEntityManager();
	}
	
	public Professor getbyId(Long id) {
		return  this.entityManager.find(Professor.class,id);
	}
	
	public List<Professor> list(){
		return this.entityManager.createNamedQuery("FROM " + Professor.class.getName()).getResultList();
	}
	
	public void add(Professor professor) {
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(professor);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	
	public void update(Professor professor) {
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(professor);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
}
