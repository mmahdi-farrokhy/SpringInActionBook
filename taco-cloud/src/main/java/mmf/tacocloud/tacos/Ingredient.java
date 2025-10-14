package mmf.tacocloud.tacos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
@AllArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;
}
