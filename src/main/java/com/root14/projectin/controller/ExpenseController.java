package com.root14.projectin.controller;

import com.root14.projectin.dto.ExpenseIdDto;
import com.root14.projectin.dto.TargetExpenditureDto;
import com.root14.projectin.dto.UserNameDto;
import com.root14.projectin.dto.ExpenseDto;
import com.root14.projectin.entity.Expense;
import com.root14.projectin.services.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/expense")
@RestController
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

    @PostMapping("/getExpensesByMonth")
    public ResponseEntity<List<Expense>> getExpensesByMonth(@RequestBody UserNameDto userNameDto) {
        return ResponseEntity.ok(expenseService.getExpensesByMonth(userNameDto));
    }


    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteExpenseById(@RequestBody ExpenseIdDto expenseIdDto) {
        return ResponseEntity.ok(expenseService.deleteExpenseByExpenseId(expenseIdDto.getExpenseId()));
    }

    @PostMapping("/updateTargetExpenditure")
    public ResponseEntity<Boolean> updateTargetExpenditure(@RequestBody TargetExpenditureDto targetExpenditureDto) {
        return ResponseEntity.ok(expenseService.updateTargetExpenditure(targetExpenditureDto));
    }

    @PostMapping("/getTargetExpenditure")
    public ResponseEntity<String> getTargetExpenditure(@RequestBody UserNameDto userNameDto) {
        return ResponseEntity.ok(expenseService.getTargetExpenditure(userNameDto));
    }
}
