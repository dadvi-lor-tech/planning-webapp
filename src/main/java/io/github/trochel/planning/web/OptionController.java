package io.github.trochel.planning.web;

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

import io.github.trochel.planning.formmodel.UserForm;
import io.github.trochel.planning.model.Profile;
import io.github.trochel.planning.model.User;
import io.github.trochel.planning.service.ProfileService;
import io.github.trochel.planning.service.ProjectService;
import io.github.trochel.planning.service.UserService;

@Controller
@RequestMapping("/options")
public class OptionController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private ProjectService projectService;

	@RequestMapping("")
	public ModelAndView options(HttpSession session) {

		String right = (String) session.getAttribute("right");
		if (!right.equals("sadmin")) {
			return new ModelAndView("redirect:/");
		}

		ModelAndView mav = new ModelAndView("options");
		mav.addObject("userList", userService.getAllUsers());
		mav.addObject("profileList", profileService.getAllProfiles());
		mav.addObject("projectList", projectService.getAllProjects());
		return mav;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView showUserForm(HttpSession session) {

		String right = (String) session.getAttribute("right");
		if (!right.equals("sadmin")) {
			return new ModelAndView("redirect:/");
		}

		ModelAndView mav = new ModelAndView("user-add", "user", new User());
		mav.addObject("profileList", profileService.getAllProfiles());
		return mav;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView submitUser(@Valid @ModelAttribute("user") UserForm userForm, BindingResult result,
			ModelMap model) {

		ModelAndView mav = new ModelAndView("user-show-new", "user", userForm);

		if (result.hasErrors()) {
			mav.setViewName("user-error");
			return mav;
		}

		// TODO: stocker en BDD
		model.addAttribute("id", userForm.getId());
		model.addAttribute("firstName", userForm.getFirstName());
		model.addAttribute("lastName", userForm.getLastName());
		model.addAttribute("rightsStatus", userForm.getRightsStatus());
		long profileId = userForm.getProfileId();
		model.addAttribute("profile", profileService.findProfileById(profileId));

		return mav;

		// return new ModelAndView("redirect:/options/user/{id}");
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
	public ModelAndView submitUser(@Valid @ModelAttribute("user") UserForm userForm, BindingResult result,
			ModelMap model, @PathVariable(value = "id") final long userId) {

		ModelAndView mav = new ModelAndView("user-show-new", "user", userForm);
		if (result.hasErrors()) {
			mav.setViewName("user-error");
			return mav;
		}

		model.addAttribute("id", userForm.getId());
		model.addAttribute("firstName", userForm.getFirstName());
		model.addAttribute("lastName", userForm.getLastName());
		model.addAttribute("rightsStatus", userForm.getRightsStatus());

		long profileId = userForm.getProfileId();
		model.addAttribute("profile", profileService.findProfileById(profileId));

		return mav;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView showProfileForm(HttpSession session) {
		
		String right = (String) session.getAttribute("right");
		if (!right.equals("sadmin")) {
			return new ModelAndView("redirect:/");
		}

		return new ModelAndView("profile-add", "profile", new Profile());
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ModelAndView submitProfile(@Valid @ModelAttribute("profile") Profile profile, BindingResult result,
			ModelMap model) {
		
		ModelAndView mav = new ModelAndView("profile-show-new", "profile", profile);
		if (result.hasErrors()) {
			mav.setViewName("profile-error");
			return mav;
		}
		
		// TODO: stocker en BDD
		model.addAttribute("name", profile.getName());
		model.addAttribute("tjmBase", profile.getTjmBase());
		model.addAttribute("id", profile.getId());
		return mav;
	}

}
