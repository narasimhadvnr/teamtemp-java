package com.venkat.teamtemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkat.teamtemp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByName(String name);
	
	List<User> findAllByRole(String role);
}
