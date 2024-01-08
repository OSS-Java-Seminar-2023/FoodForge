package com.kuvari.FoodForge.controllers;


import com.kuvari.FoodForge.dto.IngredientDto;
import com.kuvari.FoodForge.exceptions.DuplicateIngredientException;
import com.kuvari.FoodForge.exceptions.IngredientNotFoundException;
import com.kuvari.FoodForge.services.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("/list")
    public String showCreateIngredientForm(Model model) {
        List<IngredientDto> ingredientList = ingredientService.getAllIngredients();
        model.addAttribute("ingredientDto", new IngredientDto());
        model.addAttribute("ingredientList", ingredientList);
        return "ingredient";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public String createIngredient(@ModelAttribute IngredientDto ingredientDto, Model model) {
        try {
            ingredientService.createIngredient(ingredientDto);
            model.addAttribute("successMessage", "Ingredient created successfully!");
        } catch (DuplicateIngredientException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/ingredients/list";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/update/{id}")
    public String updateIngredient(@PathVariable UUID id, @ModelAttribute IngredientDto updatedIngredientDto, Model model) {
        try {
            ingredientService.editIngredient(id, updatedIngredientDto);
            model.addAttribute("successMessage", "Ingredient updated successfully!");

        } catch (IngredientNotFoundException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        } catch (DuplicateIngredientException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/ingredients/list";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable UUID id, Model model) {
        try {
            ingredientService.deleteIngredient(id);
            model.addAttribute("successMessage", "Ingredient deleted successfully!");
        } catch (IngredientNotFoundException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/ingredients/list";
    }


}
