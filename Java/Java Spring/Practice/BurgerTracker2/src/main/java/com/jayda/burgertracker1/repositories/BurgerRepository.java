package com.jayda.burgertracker1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jayda.burgertracker1.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long>{
	List<Burger> findAll();
}
