package george.taco_cloud.entities;

import george.taco_cloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientsByIdConverter implements Converter<String, Ingredients> {

    private IngredientRepository ingredientRepository;


    @Autowired
    public IngredientsByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public Ingredients convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }

}
