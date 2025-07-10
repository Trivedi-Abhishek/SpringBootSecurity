package com.abhishek.SecurityProject.repository;

import com.abhishek.SecurityProject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByName(String username);
}
