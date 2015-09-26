package fr.treeptik.petitdej.service;

import org.springframework.beans.factory.annotation.Autowired;

import fr.treeptik.petitdej.dao.PetitDejDao;
import fr.treeptik.petitdej.entities.PetitDej;

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
}
