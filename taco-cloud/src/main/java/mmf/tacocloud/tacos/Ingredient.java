package mmf.tacocloud.tacos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Document(collation = "ingredients")
public class Ingredient {
    @Id
    private final String id;
    private final String name;
    private final Type type;
}
