package com.Rajesh.SpringSecure.controller;

import com.Rajesh.SpringSecure.model.User;
import com.Rajesh.SpringSecure.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

   @Autowired
    private UserService userService;


    @GetMapping("/")
    public String home(){
        return "Welcome to our App!!";
    }

    @PostMapping("/register")
    public User adduser(@RequestBody User user){
        userService.register(user);
        return user;

    }
}
