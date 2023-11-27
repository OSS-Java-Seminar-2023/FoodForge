package com.kuvari.FoodForge.services;

import com.kuvari.FoodForge.models.Recipe;
import com.kuvari.FoodForge.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public void createRecipe(Recipe recipe){
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(Recipe recipe){
        recipeRepository.delete(recipe);
    }
}
