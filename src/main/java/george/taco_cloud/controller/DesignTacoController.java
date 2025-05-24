package george.taco_cloud.controller;

import george.taco_cloud.entities.Ingredients;
import george.taco_cloud.entities.Taco;
import george.taco_cloud.repository.IngredientRepository;
import george.taco_cloud.stufftoorder.TacoOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j //just a log
@Controller //allows component scanning and creates an instance of the class, as a bean on the main.
@RequestMapping("/design") //type of request  (and path)=
@SessionAttributes("tacoOrder")
public class DesignTacoController {




    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredients> ingredients = ingredientRepository.findAll();
        Ingredients.Type[] types = Ingredients.Type.values();
        for (Ingredients.Type type : types)  {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType((List<Ingredients>) ingredients, type));
        }
    }




    @PostMapping //to whatever has TacoOrder redirection, gets into orders/current
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {

        if (errors.hasErrors()) {
            return "design";
        }
        tacoOrder.addTaco(taco);

        //log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
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