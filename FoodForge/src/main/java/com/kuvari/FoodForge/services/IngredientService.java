package com.kuvari.FoodForge.services;

import com.kuvari.FoodForge.dto.IngredientDto;
import com.kuvari.FoodForge.exceptions.DuplicateIngredientException;
import com.kuvari.FoodForge.exceptions.IngredientNotFoundException;
import com.kuvari.FoodForge.mappers.IngredientMapper;
import com.kuvari.FoodForge.models.IngredientEntity;
import com.kuvari.FoodForge.repositories.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    private final IngredientMapper ingredientMapper;

    public List<IngredientDto> getAllIngredients() {
        List<IngredientEntity> ingredients = ingredientRepository.findAll();

        if (ingredients.isEmpty()) {
            return Collections.emptyList();
        } else {
            return ingredients.stream()
                    .map(ingredientMapper::toDto)
                    .collect(Collectors.toList());
        }
    }

    public void createIngredient(IngredientDto ingredientDto) {
        if (ingredientRepository.existsByIngredientName(ingredientDto.getIngredientName())) {
            throw new DuplicateIngredientException(ingredientDto.getIngredientName());
        }
        var ingredientEntity = ingredientMapper.toEntity(ingredientDto);
        ingredientRepository.save(ingredientEntity);
    }

    public IngredientEntity editIngredient(UUID id, IngredientDto updatedIngredientDto) {
        var existingIngredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException(id));

        if (!existingIngredient.getIngredientName().equals(updatedIngredientDto.getIngredientName())) {
            if (ingredientRepository.existsByIngredientName(updatedIngredientDto.getIngredientName())) {
                throw new DuplicateIngredientException(updatedIngredientDto.getIngredientName());
            }
        }
        var updatedIngredient = ingredientMapper.toEntity(updatedIngredientDto);
        updatedIngredient.setId(existingIngredient.getId());

         return ingredientRepository.save(updatedIngredient);
    }

    public void deleteIngredient(UUID id) {
        ingredientRepository.deleteById(id);
    }
}

