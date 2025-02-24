package com.AdrianHagjija.ExpenseTracker.dto;

import com.AdrianHagjija.ExpenseTracker.entity.Expense;
import com.AdrianHagjija.ExpenseTracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    private List<Expense> expenseList;

    private List<Income> incomeList;
}
