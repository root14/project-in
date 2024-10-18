package com.root14.projectin.services;

import com.root14.projectin.dto.ExpenseDto;
import com.root14.projectin.entity.Expense;
import com.root14.projectin.entity.User;
import com.root14.projectin.repositories.ExpenseRepository;
import com.root14.projectin.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public Boolean deleteExpenseByExpenseId(Long id) {
        expenseRepository.deleteById(id);
        return true;
    }


    public List<Expense> getAllExpensesByUserName(String userName) {
        Optional<User> foundedUser = userRepository.findByUserName(userName);
        return foundedUser.map(User::getExpenses).orElse(null);
    }

    public Boolean addExpense(ExpenseDto expenseDto) throws Exception {
        try {
            Optional<User> foundUser = userRepository.findByUserName(expenseDto.getUserName());

            if (foundUser.isPresent()) {

                Expense expense = new Expense().toBuilder().user(foundUser.get()).price(expenseDto.getPrice()).description(expenseDto.getDescription()).category(expenseDto.getCategory()).build();

                expenseRepository.save(expense);
                return true;//TODO
            } else {
                throw new Exception("User not found");
            }

        } catch (Exception exception) {
            throw new Exception(exception);
        }
    }
}
