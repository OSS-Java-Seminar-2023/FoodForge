package com.kuvari.FoodForge.controllers;

import com.kuvari.FoodForge.models.RecipeEntity;
import com.kuvari.FoodForge.dto.RecipeDto;
import com.kuvari.FoodForge.models.UserEntity;
import com.kuvari.FoodForge.services.RecipeService;
import com.kuvari.FoodForge.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class RecipeController {

    @Autowired
    private final RecipeService recipeService;


    @GetMapping("/recipe/{id}")
    public ResponseEntity<RecipeEntity> getRecipeById(@PathVariable UUID id) {
        Optional<RecipeEntity> recipe = recipeService.getRecipeById(id);
        return recipe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/create")
    public ResponseEntity<RecipeEntity> createRecipe(@RequestBody RecipeDto recipeDTO) {
        RecipeEntity createdRecipe = recipeService.createRecipeWithIngredients(recipeDTO);
        return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
    }

    @DeleteMapping("/recipe/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable UUID id) {
        boolean deletionSuccessful = recipeService.deleteRecipe(id);
        return deletionSuccessful ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
