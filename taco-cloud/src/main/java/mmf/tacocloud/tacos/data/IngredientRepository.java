package mmf.tacocloud.tacos.data;

import mmf.tacocloud.tacos.Ingredient;

import java.util.Optional;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(long id);

    Ingredient save(Ingredient ingredient);
}
