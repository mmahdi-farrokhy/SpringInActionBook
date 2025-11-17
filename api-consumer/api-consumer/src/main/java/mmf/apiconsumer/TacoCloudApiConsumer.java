package mmf.apiconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class TacoCloudApiConsumer {
    private final RestTemplate restTemplate;

    public TacoCloudApiConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Ingredient getIngredientById(String ingredientId) {
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/data-api/ingredients/{id}",
                        Ingredient.class,
                        ingredientId);

        log.info("Fetched time: {}", responseEntity.getHeaders().getDate());
        return responseEntity.getBody();
    }
}
