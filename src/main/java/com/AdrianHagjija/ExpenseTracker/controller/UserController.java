package com.AdrianHagjija.ExpenseTracker.controller;

import com.AdrianHagjija.ExpenseTracker.dto.UserDTO;
import com.AdrianHagjija.ExpenseTracker.dto.LoginRequest;
import com.AdrianHagjija.ExpenseTracker.dto.AuthResponse;
import com.AdrianHagjija.ExpenseTracker.entity.User;
import com.AdrianHagjija.ExpenseTracker.services.user.UserService;
import com.AdrianHagjija.ExpenseTracker.services.user.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    // ✅ Register User
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody User user) {
        UserDTO savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // ✅ Login User
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthResponse authResponse = authenticationService.login(loginRequest);
        return ResponseEntity.ok(authResponse);
    }
}