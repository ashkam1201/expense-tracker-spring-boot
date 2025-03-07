package com.AdrianHagjija.ExpenseTracker.services.user;

import com.AdrianHagjija.ExpenseTracker.dto.AuthResponse;
import com.AdrianHagjija.ExpenseTracker.dto.LoginRequest;
import com.AdrianHagjija.ExpenseTracker.entity.User;
import com.AdrianHagjija.ExpenseTracker.repository.UserRepository;
import com.AdrianHagjija.ExpenseTracker.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public AuthenticationService(
            AuthenticationManager authenticationManager,
            UserRepository userRepository,
            JwtUtil jwtUtil,
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    public AuthResponse login(LoginRequest loginRequest) {
        // Retrieve user from DB
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());

        if (userOptional.isEmpty() ||
                !passwordEncoder.matches(loginRequest.getPassword(), userOptional.get().getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        // Load user details
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

        // Generate JWT Token
        String token = jwtUtil.generateToken(userDetails);

        return new AuthResponse(token);
    }
}