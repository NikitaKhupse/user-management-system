package com.nikita.usermanagement.controller;

import com.nikita.usermanagement.entity.User;
import com.nikita.usermanagement.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    public AdminController(UserService userService,
                           BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){

        // encrypt password
        user.setPassword(encoder.encode(user.getPassword()));

        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}