package fr.treeptik.petitdej.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.petitdej.dao.AgendaDao;
import fr.treeptik.petitdej.entities.Agenda;
@Repository
public class AgendaJpaDao extends GenericJpaDao<Agenda, Long>implements AgendaDao {

	public AgendaJpaDao() {
		super(Agenda.class);
	}

}
