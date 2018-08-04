package com.venkat.teamtemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.venkat.teamtemp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByName(String name);
}
