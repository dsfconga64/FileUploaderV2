package com.proyecto.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.domain.User;
import com.proyecto.demo.repository.UserRepository;

import reactor.core.publisher.Flux;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;

	@Override
	public void saveUser(User newUser) {
		
		repo.save(newUser).subscribe();
	}

	@Override
	public Flux<User> getAllUsers() {
		return repo.findAll();
	}

}
