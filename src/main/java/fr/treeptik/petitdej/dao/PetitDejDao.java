package fr.treeptik.petitdej.dao;

import java.util.List;

import fr.treeptik.petitdej.entities.Membre;
import fr.treeptik.petitdej.entities.PetitDej;

public interface PetitDejDao extends GenericDao<PetitDej, Long> {

	public List<Membre> listParticipantByTeam(Long id);

	public List<Membre> listParticipantByPetitDej(Long id);
}
