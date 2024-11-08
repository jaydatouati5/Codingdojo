package com.jayda.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jayda.dojosandninjas.models.Ninja;
import com.jayda.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return this.ninjaRepository.findAll();
	}
	
	public Ninja getNinja(Long id) {
		Optional<Ninja> optionalNinja = this.ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		return null;
	}
	
	public Ninja create(Ninja ninja) {
		return this.ninjaRepository.save(ninja);
	}
	
	public Ninja update(Ninja ninja) {
		return this.ninjaRepository.save(ninja);
	}
	
	public void delete(Long id) {
		this.ninjaRepository.deleteById(id);
	}
}
