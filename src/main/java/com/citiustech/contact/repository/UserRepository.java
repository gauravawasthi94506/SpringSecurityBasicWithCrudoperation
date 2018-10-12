package com.citiustech.contact.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.contact.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}