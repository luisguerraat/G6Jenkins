package com.reto01.grupog6.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto01.grupog6.Entities.User;
import com.reto01.grupog6.Services.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() {
        return userService.getAll();

    }
    
    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean getValidateEmail(@PathVariable String email) {
        return userService.getValidateEmail(email);
    }

    @GetMapping("/{email}/{password}")
    @ResponseStatus(HttpStatus.OK)
    public User getLogin(@PathVariable String email, @PathVariable String password) {
        return userService.getLogin(email, password);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    
    
}
