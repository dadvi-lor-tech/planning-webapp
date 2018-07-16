package io.github.trochel.planning.web;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import io.github.trochel.planning.service.ProjectService;


@Controller
@SessionAttributes("right")
public class IndexController {
	
	@Autowired
	private ProjectService projectService;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index", "projectList", projectService.getAllProjects());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("rightvalue", "admin");
		return mav;
	}
	
	@RequestMapping(value = "/slogin", method = RequestMethod.GET)
	public ModelAndView superlogin() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("rightvalue", "sadmin");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private ModelAndView submitLogin(HttpServletRequest req) {//@RequestParam("right") String right){
		
		ConfigurablePasswordEncryptor encryptor = new ConfigurablePasswordEncryptor();
		encryptor.setAlgorithm("SHA-1");
		encryptor.setPlainDigest(true);
		
		String right = req.getParameter("right");
		String password = req.getParameter("password");
		
		String encrypted_pwd = encryptor.encryptPassword(password);
		
		//TODO extratction du mot de passe de la bdd
		
		if (right.equals("admin") && encrypted_pwd.equals("0DPiKuNIrrVmD8IUCuw1hQxNqZc=")) {
			ModelAndView mav = new ModelAndView("logged");
			mav.addObject("right", right);
			return mav;
		}
		else if (right.equals("sadmin") && encrypted_pwd.equals("Gjfl606iSySw0ofg3wD5FxXKLgQ=")) {
			ModelAndView mav = new ModelAndView("logged");
			mav.addObject("right", right);
			return mav;
		}
		else {
		// admin : 0DPiKuNIrrVmD8IUCuw1hQxNqZc=
		// sadmin : Gjfl606iSySw0ofg3wD5FxXKLgQ=
		
		System.out.println(encrypted_pwd);
		
		ModelAndView mav = new ModelAndView("login");
		//mav.addObject("password", password);
		//mav.addObject("right", right);
		mav.addObject("rightvalue", right);
		mav.addObject("isFalsePassword", true);
		return mav;
		}
	} 
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(SessionStatus status) {
		status.setComplete();
		return new ModelAndView("redirect:/");
	}
	
}
