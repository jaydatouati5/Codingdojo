package com.jayda.savetravels.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayda.savetravels.models.Expense;
import com.jayda.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	private final ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	
	
	@RequestMapping("")
	public String index(
			@ModelAttribute("expense") Expense expense,
			Model model
			) {
		List<Expense> expenses = this.expenseService.allExpenses();
		model.addAttribute("expenses" , expenses);
		return "index.jsp";
	}
	
	@PostMapping("")
	public String addExpense(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result,
			Model model
			) {
		if (result.hasErrors()) {
			List<Expense> expenses = this.expenseService.allExpenses();
			model.addAttribute("expenses" , expenses);
			return "index.jsp";
		}
		
		this.expenseService.create(expense);
		return "redirect:/expenses";	
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(
			@PathVariable("id") Long id,
			Model model
			) {
		Expense expense = this.expenseService.findExpense(id);
		model.addAttribute("expense" , expense);
		return "edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String update(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result,
			@PathVariable("id") Long id
			) {
		if(result.hasErrors()) {
			return "redirect:/expenses/edit/"+id;
		}
		this.expenseService.update(expense);
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.expenseService.delete(id);
		return "redirect:/expenses";
	}
	
	@RequestMapping("/{id}")
	public String expense(
			@PathVariable("id") Long id,
			Model model
			) {
		Expense expense = this.expenseService.findExpense(id);
		model.addAttribute("expense" , expense);
		
		return "show.jsp";
	}
}
