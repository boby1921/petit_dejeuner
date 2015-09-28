package fr.treeptik.petitdej.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.petitdej.entities.PetitDej;
import fr.treeptik.petitdej.service.MembreService;
import fr.treeptik.petitdej.service.PetitDejService;

@Controller
@RequestMapping("/petitdej")
public class PetitDejController {

	@Autowired
	private PetitDejService petitDejService;
	@Autowired
	private MembreService membreService;

	@RequestMapping(value = "/new.do", method = RequestMethod.GET)
	public ModelAndView add() throws Exception {
		ModelAndView modelAndView = new ModelAndView("addpetitdej");
		modelAndView.addObject("petitdej", new PetitDej());
		modelAndView.addObject("membres",membreService.findAll());
		modelAndView.addObject("petitdejs", petitDejService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/edit.do", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute("id") Long id) {
		try {
			ModelAndView modelAndView = new ModelAndView("addpetitdej");
			modelAndView.addObject("membres",membreService.findAll());
			PetitDej petitDej = petitDejService.findById(id);
			if (petitDej == null)
				return list();
			modelAndView.addObject("petitdej", petitDej);
			return modelAndView;
		} catch (Exception e) {
			return list();
		}
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("list-petitdej");
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		User customUser = (User)auth.getPrincipal();
//		int userId = customUser.getUserId();
//		System.out.println(userId);
		try {
			modelAndView.addObject("petitdejs", petitDejService.findAll());
		} catch (Exception e) {
			modelAndView.addObject("error", e.getMessage());
		}
		return modelAndView;

	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView save(@Valid PetitDej petitdej, @ModelAttribute("organisateur.id") String organisateurId,
			BindingResult result) throws NumberFormatException, Exception {
		if (result.hasErrors()) {
			return new ModelAndView("addpetitdej");
		}
		System.out.println(organisateurId);
		petitdej.setOrganisateur(membreService.findById(Long.valueOf(organisateurId)));
		try {
			if (petitdej.getId() == null) {
				petitDejService.save(petitdej);
			} else {
				System.out.println("coucou");
				petitDejService.update(petitdej);
			}
			ModelAndView modelAndView = new ModelAndView("redirect:list.do");
			return modelAndView;
		} catch (Exception e) {
			ModelAndView modelAndView = edit(petitdej.getId());
			return modelAndView;
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
