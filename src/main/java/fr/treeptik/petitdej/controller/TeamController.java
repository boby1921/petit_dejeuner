package fr.treeptik.petitdej.controller;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.petitdej.entities.Team;
import fr.treeptik.petitdej.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {


	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "/new.do", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("team", new Team());
		return modelAndView;
	}

	@RequestMapping(value = "/edit.do", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute("id") Long id) {
		try {
			ModelAndView modelAndView = new ModelAndView("Team");
			Team Team = teamService.findById(id);
			modelAndView.addObject("Team", Team);
			return modelAndView;
		} catch (Exception e) {
			return list();
		}
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("list-Team");
		try {
			modelAndView.addObject("Teams", teamService.findAll());
		} catch (Exception e) {
			modelAndView.addObject("error", e.getMessage());
		}
		return modelAndView;

	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView save(@Valid Team Team, BindingResult result)
			throws ServiceException {
		if (result.hasErrors()) {
			return new ModelAndView("Team");
		}
		try {
			if (Team.getId() == null) {
				teamService.save(Team);
			} else {
				teamService.update(Team);
			}
			ModelAndView modelAndView = new ModelAndView("redirect:list.do");
			return modelAndView;
		} catch (Exception e) {
			ModelAndView modelAndView = edit(Team.getId());
			return modelAndView;
		}
	}

}
