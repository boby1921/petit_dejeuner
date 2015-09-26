package fr.treeptik.petitdej.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.petitdej.dao.TeamDao;
import fr.treeptik.petitdej.entities.Team;

@Service
public class TeamService extends GenericService<TeamDao, Team, Long> {

	@Autowired
	private TeamDao teamdao;

	@Override
	protected TeamDao getDoa() {
		return teamdao;
	}

	public TeamDao getTeamdao() {
		return teamdao;
	}

	public void setTeamdao(TeamDao teamdao) {
		this.teamdao = teamdao;
	}
}
