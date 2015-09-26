package fr.treeptik.petitdej.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.petitdej.dao.AgendaDao;
import fr.treeptik.petitdej.entities.Agenda;

@Service
public class AgendaService extends GenericService<AgendaDao, Agenda, Long> {

	@Autowired
	private AgendaDao agendadao;

	@Override
	protected AgendaDao getDoa() {
		return agendadao;
	}

	public AgendaDao getAgendadao() {
		return agendadao;
	}

	public void setAgendadao(AgendaDao Agendadao) {
		this.agendadao = Agendadao;
	}
}
