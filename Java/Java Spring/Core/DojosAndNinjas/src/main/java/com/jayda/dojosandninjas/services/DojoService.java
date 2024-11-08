package com.jayda.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jayda.dojosandninjas.models.Dojo;
import com.jayda.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos(){
		return this.dojoRepository.findAll();
	}
	
	public Dojo getDojo(Long id) {
		Optional<Dojo> optionalDojo = this.dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		return null;
	}
	
	public Dojo create(Dojo dojo) {
		return this.dojoRepository.save(dojo);
	}
	
	public Dojo update(Dojo dojo) {
		return this.dojoRepository.save(dojo);
	}
	
	public void delete(Long id) {
		this.dojoRepository.deleteById(id);
	}
	
	
}
