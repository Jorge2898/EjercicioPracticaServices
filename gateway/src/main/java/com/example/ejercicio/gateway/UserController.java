package com.example.ejercicio.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //INSERTAR UN USUARIO
    @PostMapping("createuser/{name}/{password}")
    public User insertUser(@PathVariable("name") String name, @PathVariable("password") String pass){
        return userService.insertUser(name, pass);
    }

    //INSERTAR UN USUARIO ADMIN
    @PostMapping("createadmin/{name}/{password}")
    public User insertAdmin(@PathVariable("name") String name, @PathVariable("password") String pass){
        return userService.insertAdmin(name, pass);
    }


}
