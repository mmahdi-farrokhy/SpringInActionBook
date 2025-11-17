package mmf.apiconsumer;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
public class TacoCloudApiConsumer {
    private final RestTemplate restTemplate;

    public TacoCloudApiConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Ingredient getIngredientById(String ingredientId) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", ingredientId);
        URI uri = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/ingredients/{id}")
                .build(uriVariables);

        return restTemplate.getForObject(uri, Ingredient.class);
    }
}
