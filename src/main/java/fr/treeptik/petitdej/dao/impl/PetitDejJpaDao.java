package fr.treeptik.petitdej.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.petitdej.dao.PetitDejDao;
import fr.treeptik.petitdej.entities.Membre;
import fr.treeptik.petitdej.entities.PetitDej;

@Repository
public class PetitDejJpaDao extends GenericJpaDao<PetitDej, Long>implements PetitDejDao {

	public PetitDejJpaDao() {
		super(PetitDej.class);
	}

	@Override
	public List<Membre> listParticipantByTeam(Long id) {
		TypedQuery<Membre> query = entityManager.createQuery("select m from Membre m where m.team.id = ?", Membre.class);
		query.setParameter(1, id);
		return query.getResultList();
	}

	@Override
	public List<Membre> listParticipantByPetitDej(Long id) {
		TypedQuery<Membre> query = entityManager.createQuery("select m from Membre m join fetch m.petitDejs p where p.id = ?", Membre.class);
		query.setParameter(1, id);
		return query.getResultList();
	}

}
