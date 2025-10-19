package mmf.tacocloud.tacos.data;

import mmf.tacocloud.tacos.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {
}
