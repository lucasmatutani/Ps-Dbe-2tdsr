package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Visitor;

public class VisitorDao {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("progamer-persistence-unit");
	private EntityManager manager = factory.createEntityManager();

	public void create(Visitor Visitor) {
		
		manager.getTransaction().begin();
		manager.persist(Visitor);
		manager.getTransaction().commit();
		
		manager.clear();
	}
	
	public List<Visitor> listAll(){
		TypedQuery<Visitor> query = 
				manager.createQuery("SELECT v FROM Visitante v", Visitor.class);
		
		return query.getResultList();
	}

	public void delete(Visitor Visitor) {
		manager.getTransaction().begin();
		Visitor = manager.merge(Visitor);
		manager.remove(Visitor);
		manager.getTransaction().commit();
	}

}
