package com.example.ejercicio.gateway;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.example.ejercicio.gateway.User;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<UserDetails> findByUsername(String username);


}
