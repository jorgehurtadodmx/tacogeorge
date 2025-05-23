package george.taco_cloud.controller;

import george.taco_cloud.entities.Ingredients;
import george.taco_cloud.entities.Taco;
import george.taco_cloud.stufftoorder.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    public void addIngredientsToModel(Model model) {
        List<Ingredients> ingredients = Arrays.asList(
                new Ingredients("FLTO", "Flour Tortilla", Ingredients.Type.WRAP),
                new Ingredients("COTO", "Corn Tortilla", Ingredients.Type.WRAP),
                new Ingredients("GRBF", "Ground Beef", Ingredients.Type.PROTEIN),
                new Ingredients("CARN", "Carnitas", Ingredients.Type.PROTEIN),
                new Ingredients("TMTO", "Diced Tomatoes", Ingredients.Type.VEGGIES),
                new Ingredients("LETC", "Lettuce", Ingredients.Type.VEGGIES),
                new Ingredients("CHED", "Cheddar", Ingredients.Type.CHEESE),
                new Ingredients("JACK", "Monterrey Jack", Ingredients.Type.CHEESE),
                new Ingredients("SLSA", "Salsa", Ingredients.Type.SAUCE),
                new Ingredients("SRCR", "Sour Cream", Ingredients.Type.SAUCE)
        );


        Ingredients.Type[] types = Ingredients.Type.values();
        for (Ingredients.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients, type));


    }



}
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping //mapeo a una pagina web con formulario, nada mas
    public String showDesignForm() {
        return "design";
    }

    private Iterable<Ingredients> filterByType(List<Ingredients> ingredients, Ingredients.Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}