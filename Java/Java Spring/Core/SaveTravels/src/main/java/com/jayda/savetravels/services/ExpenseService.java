package com.jayda.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jayda.savetravels.models.Expense;
import com.jayda.savetravels.repository.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses(){
		return this.expenseRepository.findAll();
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = this.expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		return null;
	}
	
	public Expense create(Expense expense) {
		return this.expenseRepository.save(expense);
	}
	
	public Expense update(Expense expense) {
		return this.expenseRepository.save(expense);
	}
	
	public void delete(Long id) {
		this.expenseRepository.deleteById(id);
	}
}
