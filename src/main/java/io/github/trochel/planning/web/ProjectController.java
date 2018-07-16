package io.github.trochel.planning.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.github.trochel.planning.model.Project;
import io.github.trochel.planning.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/display/{projectId}/{userId}")
	public ModelAndView display( @PathVariable long projectId, @PathVariable long userId) {
				
		Project project = projectService.findProjectById(projectId);
		
		if (project == null) return new ModelAndView("redirect:/"); //TODO : faire un écran d'erreur
		
		//TODO : vérif du droit de l'user
		//getUser(userId)
		
		//TODO : Vérif que le user appartient bien au projet
		
		ModelAndView mav = new ModelAndView("project-display");
		mav.addObject("project", project);
		
		return mav;
	}
	
	//Louis : fonctions mockup
	// TODO: virer ça pour mettre en place l'extraction BDD

}
