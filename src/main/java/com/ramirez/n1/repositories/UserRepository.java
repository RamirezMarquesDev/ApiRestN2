package com.ramirez.n1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramirez.n1.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
