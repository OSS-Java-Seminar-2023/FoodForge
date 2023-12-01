package com.kuvari.FoodForge.repositories;

import com.kuvari.FoodForge.models.MealPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlanEntity, UUID> {
}
