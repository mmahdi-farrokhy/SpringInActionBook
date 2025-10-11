package mmf.tacocloud.tacos.web;

import lombok.extern.slf4j.Slf4j;
import mmf.tacocloud.tacos.Ingredient;
import mmf.tacocloud.tacos.Taco;
import mmf.tacocloud.tacos.TacoOrder;
import mmf.tacocloud.tacos.Type;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP), new Ingredient("COTO", "Corn Tortilla", Type.WRAP), new Ingredient("GRBF", "Ground Beef", Type.WRAP), new Ingredient("CARN", "Carnitas", Type.WRAP), new Ingredient("TMTO", "Diced Tomatoes", Type.WRAP), new Ingredient("LETC", "Lettuce", Type.WRAP), new Ingredient("CHED", "Cheddar", Type.WRAP), new Ingredient("JACK", "Monterrey Jack", Type.WRAP), new Ingredient("SLSA", "Salsa", Type.WRAP), new Ingredient("SRCR", "Sour Cream", Type.WRAP));

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(ingredient -> ingredient.getType().equals(type)).collect(Collectors.toList());
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        log.info("Processed taco: " + taco);
        return "redirect:/orders/current";
    }
}
