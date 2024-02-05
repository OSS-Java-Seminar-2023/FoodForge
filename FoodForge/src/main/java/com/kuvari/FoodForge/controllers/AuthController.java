package com.kuvari.FoodForge.controllers;

import com.kuvari.FoodForge.dto.UserDto;
import com.kuvari.FoodForge.models.UserEntity;
import com.kuvari.FoodForge.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class AuthController {

    @Autowired
    private UserService userService;
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping("/hello")
    public String helloPage(){
        return "hellouser";
    }


    @PostMapping("register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        Optional<UserEntity> existingUserByMail = Optional.ofNullable(userService.findUserByEmail(userDto.getEmail()));
        Optional<UserEntity> existingUserByUsername = Optional.ofNullable(userService.findUserByUsername(userDto.getUsername()));

        if(existingUserByMail.isPresent())
            result.rejectValue("email", null, "There is already an account registered with the same email!");

        if(existingUserByUsername.isPresent())
            result.rejectValue("username", null, "There is already an account registered with the same username!");

        if(result.hasErrors()){
            model.addAttribute("user",userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";

    }
}
