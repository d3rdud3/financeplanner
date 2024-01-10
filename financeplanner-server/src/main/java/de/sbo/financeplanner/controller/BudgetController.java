package de.sbo.financeplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sbo.financeplanner.domain.budget.Budget;
import de.sbo.financeplanner.domain.budget.BudgetService;

import java.util.List;

public class BudgetController {

    @Autowired
    private BudgetService budgetService;
    
    @GetMapping("/budgets")
    @ResponseBody
    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }


}
