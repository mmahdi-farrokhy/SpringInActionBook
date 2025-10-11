package mmf.tacocloud.tacos.web;

import mmf.tacocloud.tacos.Ingredient;
import mmf.tacocloud.tacos.Type;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredients = new HashMap<>();

    public IngredientByIdConverter() {
        ingredients.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
        ingredients.put("COTO", new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
        ingredients.put("GRBF", new Ingredient("GRBF", "Ground Beef", Type.WRAP));
        ingredients.put("CARN", new Ingredient("CARN", "Carnitas", Type.WRAP));
        ingredients.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", Type.WRAP));
        ingredients.put("LETC", new Ingredient("LETC", "Lettuce", Type.WRAP));
        ingredients.put("CHED", new Ingredient("CHED", "Cheddar", Type.WRAP));
        ingredients.put("JACK", new Ingredient("JACK", "Monterrey Jack", Type.WRAP));
        ingredients.put("SLSA", new Ingredient("SLSA", "Salsa", Type.WRAP));
        ingredients.put("SRCR", new Ingredient("SRCR", "Sour Cream", Type.WRAP));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredients.get(id);
    }
}
