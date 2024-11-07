package com.jayda.burgertracker1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayda.burgertracker1.models.Burger;
import com.jayda.burgertracker1.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	private final BurgerService burgerService;
	
	public BurgerController(BurgerService burgerService) {
		this.burgerService = burgerService;
	}
	
	@RequestMapping("/")
	public String index(
			@ModelAttribute("burger") Burger burger,
			Model model
			) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers" , burgers);
		
		
		
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String create(
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result,
			Model model
			) {
		if (!result.hasErrors()) {
			burgerService.create(burger);
			return "redirect:/";
		}
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers" , burgers);
		return "index.jsp";
	}
}
