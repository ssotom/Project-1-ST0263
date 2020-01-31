package com.ssotom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ssotom.model.RoleName;
import com.ssotom.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	public Optional<User> findByUsername(String username);
	
	public boolean existsByUsername(String username);
	
	public List<User> findByRole(RoleName role);

}

