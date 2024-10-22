package com.root14.projectin.repositories;

import com.root14.projectin.entity.Expense;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    List<Expense> findExpensesByCreatedAfter(LocalDateTime created);
}
