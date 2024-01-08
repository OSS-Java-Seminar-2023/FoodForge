package com.kuvari.FoodForge.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table
@Data
public class MealPlanRecipeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "mealplan_id")
    private MealPlanEntity mealPlanEntity;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipeEntity;

}
