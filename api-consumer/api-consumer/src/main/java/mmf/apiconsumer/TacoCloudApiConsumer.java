package mmf.apiconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
@Component
public class TacoCloudApiConsumer {
    private final RestTemplate restTemplate;

    public TacoCloudApiConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Ingredient getIngredientById(String ingredientId) {
        ResponseEntity<Ingredient> responseEntity = restTemplate.getForEntity("http://localhost:8080/data-api/ingredients/{id}", Ingredient.class, ingredientId);

        log.info("Fetched time: {}", responseEntity.getHeaders().getDate());
        return responseEntity.getBody();
    }

    public void updateIngredient(String ingredientId) {
        Ingredient ingredient = getIngredientById(ingredientId);
        restTemplate.put("http://localhost:8080/data-api/ingredients/{id}",
                ingredient,
                ingredientId);
    }

    public void deleteIngredient(String ingredientId) {
        Ingredient ingredient = getIngredientById(ingredientId);
        restTemplate.delete("http://localhost:8080/data-api/ingredients/{id}",
                ingredient.getId());
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return restTemplate.postForObject("http://localhost:8080/data-api/ingredients",
                ingredient,
                Ingredient.class);
    }

    public URI createIngredientForLocation(Ingredient ingredient) {
        return restTemplate.postForLocation("http://localhost:8080/data-api/ingredients",
                ingredient);
    }

    public Ingredient createIngredientForEntity(Ingredient ingredient) {
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.postForEntity("http://localhost:8080/data-api/ingredients",
                        ingredient,
                        Ingredient.class);

        log.info("New resource created at {}", responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }
}
