package com.kuvari.FoodForge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.CONFLICT)
public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(UUID id) {
        super("Ingredient with ID" + id + "not found");
    }
}

