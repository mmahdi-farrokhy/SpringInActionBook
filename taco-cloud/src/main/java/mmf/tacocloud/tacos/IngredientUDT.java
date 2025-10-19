package mmf.tacocloud.tacos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@UserDefinedType("ingredient")
public class IngredientUDT {
    private final String name;
    private final Type type;
}
