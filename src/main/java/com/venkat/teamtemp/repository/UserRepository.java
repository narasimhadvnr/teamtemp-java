package com.venkat.teamtemp.repository;

import org.springframework.data.repository.CrudRepository;

import com.venkat.teamtemp.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
}
