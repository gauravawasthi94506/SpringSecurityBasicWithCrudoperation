package com.citiustech.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.contact.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}