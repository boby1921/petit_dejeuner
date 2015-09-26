package fr.treeptik.petitdej.dao;

import java.util.List;

import fr.treeptik.petitdej.exception.DAOException;

public interface GenericDao<T, K> {

	T save(T t) throws DAOException;

	T update(T t) throws DAOException;

	void remove(T t) throws DAOException;

	void removeById(K id) throws DAOException;

	T findByID(K id) throws DAOException;

	List<T> findAll() throws DAOException;

}
