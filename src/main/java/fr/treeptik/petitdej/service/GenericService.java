package fr.treeptik.petitdej.service;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;

import fr.treeptik.petitdej.dao.GenericDao;
import fr.treeptik.petitdej.exception.DAOException;

public abstract class GenericService<T extends GenericDao<E, K>, E , K> {

	protected abstract T getDoa();
	
	@Transactional
	public E save(E e) throws ServiceException{
		try {
			return getDoa().save(e);
		} catch (DAOException er) {
			throw new ServiceException("erreur save service",er);
		}		
	}
	
	@Transactional()
	public E update(E e) throws ServiceException {
		try {
			return getDoa().update(e);
		} catch (DAOException e2) {
			throw new ServiceException("erreur update Service", e2);
		}
	}
	
	@Transactional()
	public void remove(E e) throws ServiceException {
		try {
			getDoa().remove(e);
		} catch (DAOException e2) {
			throw new ServiceException("erreur remove Service", e2);
		}
	}
	
	@Transactional()
	public E findById(K id) throws Exception {
		try {
			return getDoa().findByID(id);
		} catch (DAOException e) {
			throw new ServiceException("erreur findbyid Service", e);
		}
	}
}
