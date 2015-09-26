package fr.treeptik.petitdej.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.treeptik.petitdej.dao.GenericDao;
import fr.treeptik.petitdej.exception.DAOException;

public class GenericJpaDao<T, K> implements GenericDao<T, K>{


	@PersistenceContext
	EntityManager entityManager;
	
	private Class<T> entity;
	
	public GenericJpaDao(Class<T> entity) {
		this.entity = entity;
	}
	
	@Override
	public T save(T t) throws DAOException {
		try{
			entityManager.persist(t);
		}catch(PersistenceException e){
			throw new DAOException("erreur de persitence save", e);
		}
		
			return t;
	}

	@Override
	public T update(T t) throws DAOException {
		try {
			entityManager.merge(t);
		} catch (PersistenceException e) {
			throw new DAOException("erreur de persitence merge", e);
		}
		return t;
	}

	@Override
	public void remove(T t) throws DAOException {
		try {
			entityManager.remove(t);
		} catch (PersistenceException e) {
			throw new DAOException("erreur de persitence remove", e);
		}
		
	}

	@Override
	public void removeById(K id) throws DAOException {
		try {
			entityManager.createQuery("delete from "+entity.getSimpleName()+" where id = "+id).executeUpdate();			
		} catch (PersistenceException e) {
			throw new DAOException("erreur de persitence removeById", e);
		}
	}

	@Override
	public T findByID(K id) throws DAOException {
		try {
			return entityManager.find(entity, id);
		} catch (PersistenceException e) {
			throw new DAOException("erreur de persitence findByID", e);
		}
	}

	@Override
	public List<T> findAll() throws DAOException {
		try {
			TypedQuery<T> query = entityManager.createQuery("select t from "+entity.getSimpleName()+" t",entity);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("erreur de persitence findAll", e);		
		}
	}
}
