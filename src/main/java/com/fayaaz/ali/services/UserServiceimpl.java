package com.fayaaz.ali.services;

import com.fayaaz.ali.models.User;
import com.fayaaz.ali.repository.UserRepository;

import java.util.List;

public class UserServiceimpl implements UserService {
    private UserRepository userRepository;

    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }
}
