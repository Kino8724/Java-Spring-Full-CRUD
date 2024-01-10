package com.codingdojo.savetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

@RestController
public class ExpensesApi {
	private final ExpenseService expenseService;
	public ExpensesApi(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@GetMapping("/api/expenses")
	public List<Expense> index() {
		return expenseService.allExpenses();
	}
	
	@PostMapping("/api/expenses")
	public Expense create(@RequestParam(value="name") String name,
			@RequestParam(value="vendor") String vendor, @RequestParam(value="amount") float amount,
			@RequestParam(value="description") String description){
				Expense expense = new Expense(name, vendor, amount, description);
				return expenseService.createExpense(expense);
			}
	@GetMapping("/api/expenses/{id}")
	public Expense show(@PathVariable("id") Long id) {
		Expense expense = expenseService.findExpense(id);
		return expense;
	}
}
