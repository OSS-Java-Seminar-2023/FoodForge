package com.kuvari.FoodForge.controllers;

import com.kuvari.FoodForge.dto.IngredientDto;
import com.kuvari.FoodForge.models.RecipeEntity;
import com.kuvari.FoodForge.dto.RecipeDto;
import com.kuvari.FoodForge.models.UserEntity;
import com.kuvari.FoodForge.services.IngredientService;
import com.kuvari.FoodForge.services.RecipeService;
import com.kuvari.FoodForge.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public String showRecipeList(Model model) {
        List<RecipeDto> recipeList = recipeService.getAllRecipes();
        model.addAttribute("recipeList", recipeList);
        return "recipes";
    }

    @GetMapping("/recipe/{id}")
    public String showRecipe(@PathVariable UUID id) {
        recipeService.getRecipeById(id);
        return "recipes";
    }


    @GetMapping("/add")
    public String showCreateRecipeForm(Model model) {
        List<IngredientDto> ingredients = ingredientService.getAllIngredients();
        model.addAttribute("recipe", new RecipeDto());
        model.addAttribute("allIngredients", ingredients);
        return "add-recipe";
    }

    @PostMapping("/add")
    public String createRecipe(@ModelAttribute RecipeDto recipeDto) {
        recipeService.createRecipe(recipeDto);

        return "redirect:/recipes";
    }

    @GetMapping("/edit/{id}")
    public String showEditRecipeForm(@PathVariable UUID id, Model model) {
        var recipeDto = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipeDto);
        return "recipe/edit";
    }

//    @PostMapping("/edit/{id}")
//    public String updateRecipe(@PathVariable Long id, @ModelAttribute RecipeDto updatedRecipeDto) {
//        recipeService.editRecipe(id, updatedRecipeDto);
//        return "redirect:/recipes/list";
//    }

    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable UUID id) {
        recipeService.deleteRecipe(id);
        return "redirect:/recipes/list";
    }
}
