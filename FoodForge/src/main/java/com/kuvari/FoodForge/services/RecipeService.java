package com.kuvari.FoodForge.services;

import com.kuvari.FoodForge.dto.RecipeDto;
import com.kuvari.FoodForge.dto.RecipeIngredientDto;
import com.kuvari.FoodForge.exceptions.IngredientNotFoundException;
import com.kuvari.FoodForge.mappers.RecipeMapper;
import com.kuvari.FoodForge.models.IngredientEntity;
import com.kuvari.FoodForge.models.RecipeEntity;
import com.kuvari.FoodForge.models.RecipeIngredientEntity;
import com.kuvari.FoodForge.repositories.IngredientRepository;
import com.kuvari.FoodForge.repositories.RecipeIngredientRepository;
import com.kuvari.FoodForge.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    private final IngredientRepository ingredientRepository;

    private  final RecipeIngredientRepository recipeIngredientRepository;

    private final RecipeMapper recipeMapper;



    public Optional<RecipeEntity> getRecipeById(UUID recipeId) {
        return recipeRepository.findById(recipeId);
    }

    public List<RecipeDto> getAllRecipes() {
        List<RecipeEntity> recipes = recipeRepository.findAll();

        if (recipes.isEmpty()) {
            return Collections.emptyList();
        } else {
            return recipes.stream()
                    .map(recipeMapper::toDto)
                    .collect(Collectors.toList());
        }
    }

    public void createRecipe(RecipeDto recipeDTO) {
        var recipe = recipeMapper.toEntity(recipeDTO);

        List<RecipeIngredientEntity> ingredients = new ArrayList<>();
        for (var ingredientDto : recipeDTO.getIngredients()) {
            var ingredientId = ingredientDto.getIngredientId();
            var existingIngredient = ingredientRepository.findById(ingredientId)
                    .orElseThrow(() -> new IngredientNotFoundException(ingredientId));

            var recipeIngredient = new RecipeIngredientEntity();
            recipeIngredient.setQuantity(ingredientDto.getQuantity());
            recipeIngredient.setIngredientEntity(existingIngredient);
            recipeIngredient.setRecipeEntity(recipe);

            ingredients.add(recipeIngredient);
        }
        var recipeEntity = recipeRepository.save(recipe);

        ingredients.forEach(ingredient -> ingredient.setRecipeEntity(recipeEntity));
        recipeIngredientRepository.saveAll(ingredients);

        recipeEntity.setRecipeIngredients(ingredients);

        recipeMapper.toDto(recipeEntity);
    }


    public boolean deleteRecipe(UUID recipeId) {
        if (recipeRepository.existsById(recipeId)) {
            recipeRepository.deleteById(recipeId);
            return true;
        }
        return false;
    }
}
