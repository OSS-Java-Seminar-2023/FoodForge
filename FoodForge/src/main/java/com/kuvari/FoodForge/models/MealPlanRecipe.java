package com.kuvari.FoodForge.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table
@Data
public class MealPlanRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "mealplan_id")
    private MealPlan mealPlan;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}
