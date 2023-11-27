package com.kuvari.FoodForge.repositories;

import com.kuvari.FoodForge.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
    public Recipe findByDetails(String details);//method for testing, not to be used for anything else
}
