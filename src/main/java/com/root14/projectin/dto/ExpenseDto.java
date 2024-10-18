package com.root14.projectin.dto;

import lombok.Data;

@Data
public class ExpenseDto {
    private String userName;
    private String price;
    private String description;
    private String category;
}
