package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.acess.EntityManagerClass;
import br.com.model.Coordenador;

public class CoordenadorDAO {
	
	private static EntityManagerClass instance;
	
	protected EntityManager entityManager;
	
	
	public static EntityManagerClass getInstance() {
		if (instance == null) {
			instance = new EntityManagerClass();
		}
		return instance;
	}
	
	public CoordenadorDAO() {
		entityManager = EntityManagerClass.getEntityManager();
	}
	
	public Coordenador getbyId(Long id) {
		return  this.entityManager.find(Coordenador.class,id);
	}
	
	public List<Coordenador> list(){
		return this.entityManager.createNamedQuery("FROM " + Coordenador.class.getName()).getResultList();
	}
	
	public void add(Coordenador coordenador) {
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(coordenador);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	
	public void update(Coordenador coordenador) {
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(coordenador);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

}
