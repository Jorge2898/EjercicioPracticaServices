package com.example.ejercicio.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.example.ejercicio.gateway.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User insertUser(String name, String pass){
        Mono<UserDetails> userDB = userRepository.findByUsername(name);
        UserDetails user = userDB.block();
        User newUser = new User();
        if(user !=null){
            User errorUser = new User();
            errorUser.setUsername("Nombre de usuario erroneo");
            return errorUser;
        }else{
            newUser.setUsername(name);
            newUser.setPassword(passwordEncoder.encode(pass));
            newUser.setDomain("Usuarios");

            Set<SimpleGrantedAuthority> roles = new HashSet<SimpleGrantedAuthority>();
            SimpleGrantedAuthority rolMade = new SimpleGrantedAuthority("ROLE_USER");
            roles.add(rolMade);
            newUser.setRoles(roles);
        }
        Mono<User> saved = userRepository.save(newUser);
        return saved.block();
    }

    public User insertAdmin (String name, String pass){
        Mono<UserDetails> userDB = userRepository.findByUsername(name);
        UserDetails user = userDB.block();
        User newUser = new User();
        if(user !=null){
            User errorUser = new User();
            throw new RuntimeException ("Nombre de usuario erroneo");

        }else{
            newUser.setUsername(name);
            newUser.setPassword(passwordEncoder.encode(pass));
            newUser.setDomain("Admins");

            Set<SimpleGrantedAuthority> roles = new HashSet<SimpleGrantedAuthority>();
            SimpleGrantedAuthority rolMade = new SimpleGrantedAuthority("ROLE_ADMIN");
            roles.add(rolMade);
            newUser.setRoles(roles);
            Mono<User> saved = userRepository.save(newUser);
            return saved.block();
        }


    }


}
