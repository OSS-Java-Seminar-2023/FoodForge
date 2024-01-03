package com.kuvari.FoodForge.controllers;


import com.kuvari.FoodForge.dto.IngredientDto;
import com.kuvari.FoodForge.exceptions.DuplicateIngredientException;
import com.kuvari.FoodForge.services.IngredientService;
import com.kuvari.FoodForge.services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/ingredients")
public class IngredientController {

    @Autowired
    private final IngredientService ingredientService;

    @GetMapping("/create")
    public String showCreateIngredientForm(Model model) {
        model.addAttribute("ingredientDto", new IngredientDto());
        return "createIngredient";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public String createIngredient(@ModelAttribute IngredientDto ingredientDto, Model model) {
        try {
            ingredientService.createIngredient(ingredientDto);
            model.addAttribute("successMessage", "Ingredient created successfully!");
        } catch (DuplicateIngredientException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "createIngredient";
    }
}
