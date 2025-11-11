package org.mmf.chapter7.data;

import org.mmf.chapter7.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
