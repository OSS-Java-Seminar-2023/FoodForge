package com.kuvari.FoodForge.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;
@Entity
@Table
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "details", columnDefinition = "text")
    private String details;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "prep_time")
    private Short prepTime;

}
