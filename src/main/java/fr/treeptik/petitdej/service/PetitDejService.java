package fr.treeptik.petitdej.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.petitdej.dao.PetitDejDao;
import fr.treeptik.petitdej.entities.Membre;
import fr.treeptik.petitdej.entities.PetitDej;

@Service
public class PetitDejService extends GenericService<PetitDejDao, PetitDej, Long> {

	@Autowired
	private PetitDejDao petitDejdao;

	@Override
	protected PetitDejDao getDoa() {
		return petitDejdao;
	}

	public PetitDejDao getPetitDejdao() {
		return petitDejdao;
	}

	public void setPetitDejdao(PetitDejDao PetitDejdao) {
		this.petitDejdao = PetitDejdao;
	}
	
	public List<Membre> listParticipantByTeam(Long id) {
		return petitDejdao.listParticipantByTeam(id);
	}
	
	public List<Membre> listParticipantByPetitDej(Long id) {
		return petitDejdao.listParticipantByPetitDej(id);
	}
}
