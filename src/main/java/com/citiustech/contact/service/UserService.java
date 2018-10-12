package com.citiustech.contact.service;

import com.citiustech.contact.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}