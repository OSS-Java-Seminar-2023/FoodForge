package com.kuvari.FoodForge.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table
@Data
public class MealPlanRecipe {
    @Id
    @Column(name ="id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "mealplan_id")
    private MealPlan mealPlan;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}
