package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.acess.EntityManagerClass;
import br.com.model.Aluno;



public class AlunoDAO {
	
	private static EntityManagerClass instance;
	
	protected EntityManager entityManager;
	
	
	public static EntityManagerClass getInstance() {
		if (instance == null) {
			instance = new EntityManagerClass();
		}
		return instance;
	}
	
	public AlunoDAO() {
		entityManager = EntityManagerClass.getEntityManager();
	}
	
	public Aluno getbyId(Long id) {
		return  this.entityManager.find(Aluno.class,id);
	}
	
	public List<Aluno> list(){
		return this.entityManager.createNamedQuery("FROM " + Aluno.class.getName()).getResultList();
	}
	
	public void add(Aluno aluno) {
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(aluno);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	
	public void update(Aluno aluno) {
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(aluno);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

}
