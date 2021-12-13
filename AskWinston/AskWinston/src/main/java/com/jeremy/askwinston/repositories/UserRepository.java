package com.jeremy.askwinston.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jeremy.askwinston.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
