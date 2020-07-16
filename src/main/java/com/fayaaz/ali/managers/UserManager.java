package com.fayaaz.ali.managers;

import com.fayaaz.ali.models.User;
import com.fayaaz.ali.services.UserService;

import java.util.Collections;
import java.util.List;

public class UserManager {
    private UserService userService;

    public UserManager(UserService userService) {
        this.userService = userService;
    }

    public UserManager() {

    }

    public List<User> getAllUsers() {

        return this.userService.getAllUsers();
    }
}
