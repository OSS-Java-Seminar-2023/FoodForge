package com.kuvari.FoodForge.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    @NotEmpty(message = "User Name field is empty!")
    private String username;

    @NotEmpty(message = "Email field is empty!")
    private String email;

    @NotEmpty(message = "Password field is empty!")
    private String password;

}