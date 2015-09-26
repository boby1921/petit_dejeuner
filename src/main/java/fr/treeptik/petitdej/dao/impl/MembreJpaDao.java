package fr.treeptik.petitdej.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.petitdej.dao.MembreDao;
import fr.treeptik.petitdej.entities.Membre;

@Repository
public class MembreJpaDao extends GenericJpaDao<Membre, Long>implements MembreDao {

	public MembreJpaDao() {
		super(Membre.class);
	}

}
