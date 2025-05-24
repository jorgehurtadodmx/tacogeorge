package george.taco_cloud.entities;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientsByIdConverter implements Converter<String, Ingredients> {

    private Map<String, Ingredients> ingredientsMap = new HashMap<>();

    public IngredientsByIdConverter() {
        ingredientsMap.put("FLTO", new Ingredients("FLTO", "Flour tortilla", Ingredients.Type.WRAP));
        ingredientsMap.put("COTO", new Ingredients("COTO", "Coto stuff", Ingredients.Type.WRAP));
        ingredientsMap.put("GRBF", new Ingredients("GRBF", "Grbf stuff", Ingredients.Type.PROTEIN));
        ingredientsMap.put("CARN", new Ingredients("CARN", "CARN STUFF", Ingredients.Type.PROTEIN));
        ingredientsMap.put("TMTO", new Ingredients("TMTO", "TMNTO STUFF", Ingredients.Type.VEGGIES));
        ingredientsMap.put("LETC", new Ingredients("LETC", "LETC STUFF", Ingredients.Type.VEGGIES));
        ingredientsMap.put("CHED", new Ingredients("CHED", "CHED STUFF", Ingredients.Type.CHEESE));
        ingredientsMap.put("JACK", new Ingredients("JACK", "JACK STUF", Ingredients.Type.CHEESE));
        ingredientsMap.put("SLSA", new Ingredients("SLSA", "SLSA STUFF", Ingredients.Type.SAUCE));
        ingredientsMap.put("SRCR", new Ingredients("SRCR", "SRCR STUFF", Ingredients.Type.SAUCE));


    }


    public Ingredients convert(String id) {
        return ingredientsMap.get(id);
    }


}
