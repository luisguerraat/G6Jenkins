package com.reto01.grupog6.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto01.grupog6.Entities.User;
import com.reto01.grupog6.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return (List<User>) userRepository.getAll();
    }

    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    public Boolean getValidateEmail(String email) {
        return userRepository.getValidateEmail(email);
    }

    public User getLogin(String email, String password) {
        return userRepository.getLogin(email, password);
    }
    
}
