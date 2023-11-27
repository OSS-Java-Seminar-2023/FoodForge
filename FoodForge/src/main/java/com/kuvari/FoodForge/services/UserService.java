package com.kuvari.FoodForge.services;

import com.kuvari.FoodForge.models.User;
import com.kuvari.FoodForge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user){
        userRepository.save(user);

    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
