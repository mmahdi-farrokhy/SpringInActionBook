package mmf.apiconsumer;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class TacoCloudApiConsumer {
    private final RestTemplate restTemplate;

    public TacoCloudApiConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Ingredient getIngredientById(String ingredientId) {
        Map<String, String> uriVariables = new HashMap<String, String>();
        uriVariables.put("id", ingredientId);
        return restTemplate
                .getForObject("http://localhost:8080/ingredients/{id}",
                        Ingredient.class,
                        uriVariables);
    }
}
