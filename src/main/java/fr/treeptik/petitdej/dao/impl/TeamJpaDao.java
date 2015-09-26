package fr.treeptik.petitdej.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.petitdej.dao.TeamDao;
import fr.treeptik.petitdej.entities.Team;

@Repository
public class TeamJpaDao extends GenericJpaDao<Team, Long>implements TeamDao {

	public TeamJpaDao() {
		super(Team.class);
	}

}
