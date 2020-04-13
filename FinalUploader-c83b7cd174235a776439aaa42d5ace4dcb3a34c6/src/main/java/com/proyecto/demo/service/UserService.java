package com.proyecto.demo.service;

import java.util.List;

import com.proyecto.demo.domain.User;

import reactor.core.publisher.Flux;



public interface UserService {
	
	public void saveUser(User newUser);
	public Flux<User> getAllUsers();
}
