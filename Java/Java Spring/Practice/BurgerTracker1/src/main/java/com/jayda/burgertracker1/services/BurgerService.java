package com.jayda.burgertracker1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jayda.burgertracker1.models.Burger;
import com.jayda.burgertracker1.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	public List<Burger> allBurgers(){
		return burgerRepository.findAll();
	}
	
	public Burger create(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public Burger update(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	
}
