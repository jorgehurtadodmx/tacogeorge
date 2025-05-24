package george.taco_cloud.repository;

import george.taco_cloud.entities.Ingredients;

import java.util.Optional;

public interface IngredientRepository {

    Iterable<Ingredients> findAll();

    Optional<Ingredients> findById(String id);

    Ingredients save(Ingredients ingredients);
}


