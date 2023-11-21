package com.kuvari.FoodForge.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table
@Data
public class Review {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "score")
    private Byte score;

    @Column(name = "review_date")
    private java.sql.Date reviewDate;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
