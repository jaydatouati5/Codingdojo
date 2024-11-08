package com.jayda.dojosandninjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayda.dojosandninjas.models.Dojo;
import com.jayda.dojosandninjas.models.Ninja;
import com.jayda.dojosandninjas.services.DojoService;
import com.jayda.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	public NinjaController(NinjaService ninjaService , DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(
			@ModelAttribute("ninja") Ninja ninja,
			Model model
			) {
		List<Dojo> dojos = this.dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas")
	public String createNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result
			) {
		if (!result.hasErrors()) {
			this.ninjaService.create(ninja);
		}
		
		return "redirect:/ninjas/new";
	}
}
