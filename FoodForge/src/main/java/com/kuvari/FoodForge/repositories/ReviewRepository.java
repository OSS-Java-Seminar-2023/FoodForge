package com.kuvari.FoodForge.repositories;

import com.kuvari.FoodForge.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
}
