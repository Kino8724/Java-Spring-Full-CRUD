package com.codingdojo.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	public Expense createExpense(Expense e) {
		return expenseRepository.save(e);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			return null;
		}
	}

	public Expense updateExpense(Expense e) {
		return expenseRepository.save(e);
	}

	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
		return;
	}
	
	
}
