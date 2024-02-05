package com.kuvari.FoodForge.services;

import com.kuvari.FoodForge.dto.UserDto;
import com.kuvari.FoodForge.models.UserEntity;
import com.kuvari.FoodForge.models.enums.Role;
import com.kuvari.FoodForge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(UserDto userDto){
        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPasswd(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);
    }

    public UserEntity findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserEntity findUserByUsername(String username){return userRepository.findByUsername(username);}

    public List<UserDto> findAllUsers(){
        List<UserEntity> users = userRepository.findAll();
        return users.stream().
                map((user)-> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(UserEntity user) {
        return new UserDto(user.getUsername(),
                user.getEmail(),
                user.getPasswd());

    }


}
