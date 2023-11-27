package com.kuvari.FoodForge.repositories;

import com.kuvari.FoodForge.models.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MealPlanRepository extends JpaRepository<MealPlan, UUID> {
}
