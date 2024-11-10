package com.jayda.loginandregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayda.loginandregistration.models.LoginUser;
import com.jayda.loginandregistration.models.User;
import com.jayda.loginandregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index(Model model , HttpSession session) {
		if (session.getAttribute("userId") != null) {
			return "redirect:/welcome";
		}
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User user,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		
		User newUser = this.userService.register(user , result);
		
		if (newUser == null) {
			model.addAttribute("newLogin" , new User());
			return "index.jsp";
		}
		
		session.setAttribute("userId", newUser.getId());
		
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		User user = this.userService.login(newLogin, result);
		
		if (user == null) {
			model.addAttribute("newUser", new User());
            return "index.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		
		return "redirect:/welcome";
	}
	
	@RequestMapping("/welcome")
	public String welcome(
			HttpSession session,
			Model model
			) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = this.userService.getUser((Long)session.getAttribute("userId"));
		model.addAttribute("user" , user);
		return "welcome.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/";
	}
	
	
}
