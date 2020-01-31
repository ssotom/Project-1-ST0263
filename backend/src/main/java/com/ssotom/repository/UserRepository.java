package com.ssotom.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.ssotom.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	public Optional<User> findByUsername(String username);
	
	public boolean existsByUsername(String username);

}

