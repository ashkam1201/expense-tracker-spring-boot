package com.AdrianHagjija.ExpenseTracker.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}