package com.kuvari.FoodForge.repositories;
import com.kuvari.FoodForge.models.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, UUID> {


    boolean existsByIngredientName(String ingredientName);
}
