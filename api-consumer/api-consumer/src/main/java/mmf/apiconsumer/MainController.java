package mmf.apiconsumer;

import org.springframework.web.bind.annotation.*;

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
}
