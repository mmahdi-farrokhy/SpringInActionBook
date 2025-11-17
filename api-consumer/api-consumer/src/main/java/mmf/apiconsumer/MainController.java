package mmf.apiconsumer;

import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/consumer")
public class MainController {
    private final TacoCloudApiConsumer consumer;

    public MainController(TacoCloudApiConsumer consumer) {
        this.consumer = consumer;
    }

    @GetMapping("/get/{ingredientId}")
    public Ingredient get(@PathVariable("ingredientId") String ingredientId) {
        return consumer.getIngredientById(ingredientId);
    }

    @PutMapping("/put/{ingredientId}")
    public void put(@PathVariable("ingredientId") String ingredientId) {
        consumer.updateIngredient(ingredientId);
    }

    @DeleteMapping("/delete/{ingredientId}")
    public void delete(@PathVariable("ingredientId") String ingredientId) {
        consumer.deleteIngredient(ingredientId);
    }

    @PostMapping("/post")
    public Ingredient post(Ingredient ingredient) {
        return consumer.createIngredient(ingredient);
    }

    @PostMapping("/post-for-location")
    public URI postForLocation(Ingredient ingredient) {
        return consumer.createIngredientForLocation(ingredient);
    }
}
