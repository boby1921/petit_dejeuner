package fr.treeptik.petitdej.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.petitdej.dao.MembreDao;
import fr.treeptik.petitdej.entities.Membre;

@Service
public class MembreService extends GenericService<MembreDao, Membre, Long> {

	@Autowired
	private MembreDao membredao;

	@Override
	protected MembreDao getDoa() {
		return membredao;
	}

	public MembreDao getMembredao() {
		return membredao;
	}

	public void setMembredao(MembreDao Membredao) {
		this.membredao = Membredao;
	}
}
