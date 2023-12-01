package com.kuvari.FoodForge.controllers;

import com.kuvari.FoodForge.dto.UserDto;
import com.kuvari.FoodForge.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.security.auth.login.LoginException;

@Controller
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;


    @GetMapping("/register")
    public String RegistrationForm() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userDto") UserDto userDto, Model model) {
        try {
            userService.registerUser(userDto);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "registration";
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute UserDto userDto, Model model) {
        try {
            if (userService.loginUser(userDto.username(), userDto.password())) {
                return "redirect:/dashboard";
            } else {
                throw new LoginException("Invalid username or password");
            }
        } catch (LoginException e) {
            model.addAttribute("error", "Login failed: " + e.getMessage());
            return "login";
        }
    }

}