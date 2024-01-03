package com.kuvari.FoodForge.services;

import com.kuvari.FoodForge.dto.IngredientDto;
import com.kuvari.FoodForge.exceptions.DuplicateIngredientException;
import com.kuvari.FoodForge.mappers.IngredientMapper;
import com.kuvari.FoodForge.models.IngredientEntity;
import com.kuvari.FoodForge.repositories.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    private final IngredientMapper ingredientMapper;

    public void createIngredient(IngredientDto ingredientDto) {
        if (ingredientRepository.existsByIngredientName(ingredientDto.getIngredientName())) {
            throw new DuplicateIngredientException(ingredientDto.getIngredientName());
        }
        IngredientEntity ingredientEntity = ingredientMapper.toEntity(ingredientDto);
        ingredientRepository.save(ingredientEntity);
    }
}
