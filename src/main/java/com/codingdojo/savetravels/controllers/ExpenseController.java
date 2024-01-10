package com.codingdojo.savetravels.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	private final ExpenseService expenseService;
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	// Shows all Expenses
	@GetMapping("/expenses")
	public String indexPage(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("allExpenses", expenses);
		return "index.jsp";
	}
	// Creating new Expense
	@PostMapping("/expense/new")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("allExpenses", expenses);
			return "index.jsp";
		}
		else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	// Showing the page for editing
	@GetMapping("/expense/edit/{id}")
	public String editPage(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	// Sending the Put request to edit the expense
	@PutMapping("/expense/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "edit.jsp";
		}else {
			expenseService.updateExpense(expense); 
		}
		
		return "redirect:/expenses";
	}
	// Processing Delete route
	@DeleteMapping("/expense/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	// View one Expense
	@GetMapping("/expense/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "expense.jsp";
	}
}
