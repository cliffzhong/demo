package com.example.demo.daoimpl.repository;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password) throws UserNotFoundException;

    User findByName(String name);
}
