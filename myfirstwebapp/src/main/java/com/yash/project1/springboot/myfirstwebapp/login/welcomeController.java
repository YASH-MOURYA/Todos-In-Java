package com.yash.project1.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

//import com.yash.project1.springboot.myfirstwebapp.loginAuthenticationService.AuthenticationSerice;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SessionAttributes("name")
// renamed 1st LoginController
public class welcomeController {

	// private Logger logger= LoggerFactory.getLogger(getClass());

	// @RequestMapping("login")
//	public String gotoLoginPage(@RequestParam String name ,ModelMap model) {
//		model.put("name", name);
//		logger.debug("Request param is{}", name);
//		logger.info("Request param is{}", name);
	// System.out.println("Request param is "+ name); not Recommended

	//private AuthenticationSerice auth;

//	public LoginController(AuthenticationSerice auth) {
//		super();
//		this.auth = auth;
//	}

//	@RequestMapping(value="login",method = RequestMethod.GET)
//	public String gotoLoginPage() {
//		return "login";
//	}

	

//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		if (auth.authenticate(name, password)) {
//			model.put("name", name);
//			model.put("password", password);
//
//			// Authentication
//
//			return "welcome";
//		} else {
//			model.put("errorMassage", "Invaild Credential Please Try Again");
//			return "login";
//		}
//	}
	
	//secend-2nd
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedUsername());
		return "welcome";
	}
	private String getLoggedUsername() {
		Authentication authentication =SecurityContextHolder.getContext()
           .getAuthentication();
		return authentication.getName();}
}
