package com.kuvari.FoodForge.services;

import com.kuvari.FoodForge.dto.UserDto;
import com.kuvari.FoodForge.models.UserEntity;
import com.kuvari.FoodForge.models.enums.Role;
import com.kuvari.FoodForge.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    public UserRepository userRepository;



    public void registerUser(UserDto userDto) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (isEmailTaken(userDto.email())) {
                throw new RuntimeException("Email is already taken");
            }

            if (isUsernameTaken(userDto.username())) {
                throw new RuntimeException("Username is already taken");
            }

            if (!isStrongPassword(userDto.password())) {
                throw new RuntimeException("Password is not strong enough");
            }
        var userEntity = new UserEntity();
        userEntity.setRole(Role.USER); //Default role
        userEntity.setUsername(userDto.username());
        userEntity.setEmail(userDto.email());
        userEntity.setPasswd(passwordEncoder.encode(userDto.password()));

        userRepository.save(userEntity);
    }

    public boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean isUsernameTaken(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public boolean isStrongPassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*");
    }

    public boolean loginUser(String username, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return passwordEncoder.matches(password, userEntity.getPasswd());
    }



}
