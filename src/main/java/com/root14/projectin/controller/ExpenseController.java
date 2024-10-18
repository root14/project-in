package com.root14.projectin.controller;

import com.root14.projectin.dto.AllExpenseDto;
import com.root14.projectin.dto.ExpenseDto;
import com.root14.projectin.entity.Expense;
import com.root14.projectin.services.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/expense")
@Controller
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> addExpense(@RequestBody ExpenseDto expenseDto) throws Exception {
        return ResponseEntity.ok(expenseService.addExpense(expenseDto));
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<Expense>> getAllExpenses(@RequestBody AllExpenseDto allExpenseDto) throws Exception {
        return ResponseEntity.ok(expenseService.getAllExpensesByUserId(allExpenseDto.getUserName()));
    }


    //  @PostMapping("/delete")
    //public ResponseEntity<Boolean> deleteExpense(@RequestBody ExpenseDto expenseDto) throws Exception {

    //  }
}
