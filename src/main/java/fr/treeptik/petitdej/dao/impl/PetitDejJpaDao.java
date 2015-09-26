package fr.treeptik.petitdej.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.petitdej.dao.PetitDejDao;
import fr.treeptik.petitdej.entities.PetitDej;

@Repository
public class PetitDejJpaDao extends GenericJpaDao<PetitDej, Long>implements PetitDejDao {

	public PetitDejJpaDao() {
		super(PetitDej.class);
	}

}
