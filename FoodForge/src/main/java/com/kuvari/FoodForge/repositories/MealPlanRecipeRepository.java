package com.kuvari.FoodForge.repositories;

import com.kuvari.FoodForge.models.MealPlanRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MealPlanRecipeRepository extends JpaRepository<MealPlanRecipe, UUID> {
}
