package com.jayda.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilController {
	@GetMapping("/")
	public String index() {
		return "redirect:/omikuji";	
	}
}
