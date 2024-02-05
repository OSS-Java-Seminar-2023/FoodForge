package com.kuvari.FoodForge.models;

import com.kuvari.FoodForge.models.enums.Difficulty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "Recipe")
@Data
public class RecipeEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String title;

    @Column
    private String details;

    @Column
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column
    private Short prepTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "recipeEntity")
    List<ReviewEntity> reviews;

}
