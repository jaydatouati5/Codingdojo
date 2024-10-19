package com.jayda.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {
	@GetMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}else {
			session.setAttribute("count", (int) session.getAttribute("count") + 1);
		}
		return"index.jsp";
	}
	//	Ninja Bonus 1 :
	@GetMapping("/addtwo")
	public String addTwo(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}else {
			session.setAttribute("count", (int) session.getAttribute("count") + 2);
		}
		return"index.jsp";
	}
	
	@GetMapping("/counter")
	public String counter(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		return "countDisplay.jsp";
	}
	
	//	Ninja Bonus 2 :
	@GetMapping("/reset")
	public String resetSession(HttpSession session) {
		session.setAttribute("count", 0);
		return "countDisplay.jsp";
	}
}
