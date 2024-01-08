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
public class ReviewEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    private UUID id;

    @Column
    private Byte score;

    @Column
    private java.sql.Date reviewDate;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipeEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

}
