package com.proyecto.demo.repository;



import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.proyecto.demo.domain.User;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCosmosRepository<User, String> {
    Flux<User> findByFirstName(String firstName);
}