package mmf.tacocloud.tacos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    private final String id;
    private final String name;
    private final Type type;
}
