package george.taco_cloud.repository;

import george.taco_cloud.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}


