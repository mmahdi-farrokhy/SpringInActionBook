package mmf.apiconsumer;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TacoCloudApiConsumer {
    private final RestTemplate restTemplate;

    public TacoCloudApiConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Ingredient getIngredientById(String ingredientId) {
        return restTemplate
                .getForObject("http://localhost:8080/ingredients/{id}",
                        Ingredient.class,
                        ingredientId);
    }
}
