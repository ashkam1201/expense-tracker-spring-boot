package com.AdrianHagjija.ExpenseTracker.services.user;

import com.AdrianHagjija.ExpenseTracker.dto.UserDTO;
import com.AdrianHagjija.ExpenseTracker.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO saveUser(User user);
    Optional<UserDTO> findByUsername(String username);
    List<UserDTO> getAllUsers();
}