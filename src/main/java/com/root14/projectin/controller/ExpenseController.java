package com.root14.projectin.controller;

import com.root14.projectin.dto.ExpenseIdDto;
import com.root14.projectin.dto.UserNameDto;
import com.root14.projectin.dto.ExpenseDto;
import com.root14.projectin.entity.Expense;
import com.root14.projectin.services.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public ResponseEntity<List<Expense>> getAllExpenses(@RequestBody UserNameDto userNameDto) {
        return ResponseEntity.ok(expenseService.getAllExpensesByUserName(userNameDto.getUserName()));
    }


    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteExpenseById(@RequestBody ExpenseIdDto expenseIdDto) {
        return ResponseEntity.ok(expenseService.deleteExpenseByExpenseId(expenseIdDto.getExpenseId()));
    }
}
