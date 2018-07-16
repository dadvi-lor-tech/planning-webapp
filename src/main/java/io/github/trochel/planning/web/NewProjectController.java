package io.github.trochel.planning.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.github.trochel.planning.formmodel.PhaseForm;
import io.github.trochel.planning.formmodel.ProjectForm;
import io.github.trochel.planning.model.Phase;
import io.github.trochel.planning.model.Project;
import io.github.trochel.planning.model.RightsStatus;
import io.github.trochel.planning.model.User;
import io.github.trochel.planning.service.PhaseService;
import io.github.trochel.planning.service.ProjectService;
import io.github.trochel.planning.service.UserService;

@Controller
@RequestMapping(value = "/project/add")
public class NewProjectController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private PhaseService phaseService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView addProject(HttpSession session) {

		String right = (String) session.getAttribute("right");
		if (!(right.equals("sadmin") || right.equals("admin"))) {
			return new ModelAndView("redirect:/");
		}

		ModelAndView mav = new ModelAndView("project-add", "projectForm", new ProjectForm());

		List<User> users = userService.getAllUsers();
		List<User> admins = new ArrayList<>();
		for (User user : users) {
			if (user.getRightsStatus() == RightsStatus.ADMIN) {
				admins.add(user);
			}
		}
		mav.addObject("admins", admins);

		return mav;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView showNewProject(@Valid @ModelAttribute("project") ProjectForm projectForm, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return new ModelAndView("project-error", "projectForm", projectForm);
		}

		// TODO: stocker les champs suivants en BDD
		Project newproject = new Project();
		model.addAttribute("id", 0); // A VIRER
		model.addAttribute("budget", projectForm.getBudget());
		model.addAttribute("name", projectForm.getName());
		model.addAttribute("admin", projectForm.getAdminId());

		//TODO: la redirection inscrit les attributs en clair dans l'URL, pas top... A corriger.
		return new ModelAndView("redirect:/project/add/{id}");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView addPhases(@Valid @ModelAttribute("project") Project project, BindingResult result,
			ModelMap model, HttpSession session, @PathVariable(value = "id") final long projectId) {

		String right = (String) session.getAttribute("right");
		if (!(right.equals("sadmin") || right.equals("admin"))) {
			return new ModelAndView("redirect:/");
		}
		
		//System.out.println(project.getAdmin().getFirstName());

		ModelAndView mav = new ModelAndView("project-show-new"); //, "projectForm", projectForm);

		model.addAttribute("id", project.getId());
		model.addAttribute("budget", project.getBudget());
		model.addAttribute("name", project.getName());
		model.addAttribute("admin", userService.findAdminByProjectId(projectId));
		model.addAttribute("phaseList", phaseService.findPhasesByProjectId(projectId));

		return mav;
	}

	@RequestMapping(value = "/{id}/addPhase", method = RequestMethod.GET)
	public ModelAndView addPhase(HttpSession session, @PathVariable(value = "id") final long projectId) {

		String right = (String) session.getAttribute("right");
		if (!(right.equals("sadmin") || right.equals("admin"))) {
			return new ModelAndView("redirect:/");
		}

		ModelAndView mav = new ModelAndView("phase-add", "phase", new Phase());

		mav.addObject("project", projectService.findProjectById(projectId));
		mav.addObject("userList", userService.getAllUsers());

		return mav;
	}

	@RequestMapping(value = "/{id}/addPhase", method = RequestMethod.POST)
	public ModelAndView submitPhase(@Valid @ModelAttribute("phase") PhaseForm phaseForm, BindingResult result,
			ModelMap model) {
		
		//System.out.println(phaseForm.getEndDate());
		return new ModelAndView("redirect:/project/add/{id}");
	}

	@RequestMapping(value = "/{id}/attributeCharges", method = RequestMethod.GET)
	public ModelAndView attributeCharges(HttpSession session, @PathVariable(value = "id") final long projectId) {

		String right = (String) session.getAttribute("right");
		if (!(right.equals("sadmin") || right.equals("admin"))) {
			return new ModelAndView("redirect:/");
		}
		
		//Project project = projectService.findProjectById(projectId);
		

		return new ModelAndView("charges-add", "project", projectService.findProjectById(2));
	}

	@RequestMapping(value = "/{id}/attributeCharges", method = RequestMethod.POST)
	public ModelAndView attributeCharges(@Valid @ModelAttribute("project") Project project, BindingResult result,
			ModelMap model) {
		//TODO: faire les sauvegardes en BDD
		return new ModelAndView("redirect:/");
	}
	
}
