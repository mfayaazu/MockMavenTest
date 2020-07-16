package com.fayaaz.ali.repository;


import com.fayaaz.ali.models.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();
}
