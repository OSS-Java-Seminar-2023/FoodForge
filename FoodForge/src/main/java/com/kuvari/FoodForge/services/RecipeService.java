package com.kuvari.FoodForge.services;

import com.kuvari.FoodForge.dto.IngredientDto;
import com.kuvari.FoodForge.dto.RecipeDto;
import com.kuvari.FoodForge.dto.RecipeIngredientDto;
import com.kuvari.FoodForge.models.IngredientEntity;
import com.kuvari.FoodForge.models.RecipeEntity;
import com.kuvari.FoodForge.models.RecipeIngredientEntity;
import com.kuvari.FoodForge.models.UserEntity;
import com.kuvari.FoodForge.repositories.IngredientRepository;
import com.kuvari.FoodForge.repositories.RecipeIngredientRepository;
import com.kuvari.FoodForge.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    public Optional<RecipeEntity> getRecipeById(UUID recipeId) {
        return recipeRepository.findById(recipeId);
    }

    public RecipeEntity createRecipeWithIngredients(RecipeDto recipeDTO) {
        RecipeEntity recipe = new RecipeEntity();
        recipe.setTitle(recipeDTO.getTitle());
        recipe.setDetails(recipeDTO.getDetails());
        recipe.setDifficulty(recipeDTO.getDifficulty());
        recipe.setPrepTime(recipeDTO.getPrepTime());

        List<RecipeIngredientEntity> recipeIngredients = new ArrayList<>();
        for (RecipeIngredientDto ingredientDto : recipeDTO.getIngredients()) {
            var existingIngredient = ingredientRepository.findById(ingredientDto.getIngredientId())
                    .orElseThrow(() -> new NoSuchElementException("Ingredient not found"));

            RecipeIngredientEntity recipeIngredient = new RecipeIngredientEntity();
            recipeIngredient.setQuantity(ingredientDto.getQuantity());
            recipeIngredient.setRecipeEntity(recipe);
            recipeIngredient.setIngredientEntity(existingIngredient);
            recipeIngredients.add(recipeIngredient);
        }
        recipe.setRecipeIngredients(recipeIngredients);
        return recipeRepository.save(recipe);
    }

    public boolean deleteRecipe(UUID recipeId) {
        if (recipeRepository.existsById(recipeId)) {
            recipeRepository.deleteById(recipeId);
            return true;
        }
        return false;
    }
}
