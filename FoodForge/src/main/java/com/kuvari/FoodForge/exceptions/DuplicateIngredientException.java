package com.kuvari.FoodForge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateIngredientException extends RuntimeException {

    public DuplicateIngredientException(String ingredientName) {
        super("Ingredient with name '" + ingredientName + "' already exists.");
    }
}
