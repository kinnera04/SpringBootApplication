package com.javaSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaSpring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
