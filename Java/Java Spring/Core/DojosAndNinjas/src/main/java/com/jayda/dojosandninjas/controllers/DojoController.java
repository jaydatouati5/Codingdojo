package com.jayda.dojosandninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayda.dojosandninjas.models.Dojo;
import com.jayda.dojosandninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {

	private final DojoService dojoService;
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos")
	public String createDojo(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result
			) {
		if (!result.hasErrors()) {
			this.dojoService.create(dojo);
		}
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("/dojos/{id}")
	public String getDojo(@PathVariable("id") Long id,Model model) {
		Dojo dojo = this.dojoService.getDojo(id);
		model.addAttribute("dojo" , dojo);
		return "showNinjas.jsp";
	}
	
	
	
}
