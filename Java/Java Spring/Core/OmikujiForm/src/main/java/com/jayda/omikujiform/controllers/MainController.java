package com.jayda.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/omikuji")
public class MainController {
	@GetMapping("")
	public String omikuji() {
		return "index.jsp";
	}
	
	@PostMapping("/form")
	public String form(
			@RequestParam(value="number") String number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="living") String living,
			@RequestParam(value="message") String message,
			HttpSession session
			) {
		
		String m = String.format("In %s years, you will live in %s with %s as your roommate, %s for a living. The next time you see a %s, you will have good luck. Also, %s.", number, city, person, hobby, living, message);
		session.setAttribute("message", m);
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/show")
	public String show() {
		return "show.jsp";	
	}

}
