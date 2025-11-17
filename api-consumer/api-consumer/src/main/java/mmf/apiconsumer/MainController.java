package mmf.apiconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consumer")
public class MainController {
    private final TacoCloudApiConsumer consumer;

    public MainController(TacoCloudApiConsumer consumer) {
        this.consumer = consumer;
    }

    @GetMapping("/{ingredientId}")
    public Ingredient hello(@PathVariable("ingredientId") String ingredientId) {
        return consumer.getIngredientById(ingredientId);
    }
}
