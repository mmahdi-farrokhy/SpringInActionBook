package mmf.tacocloud.tacos.data;

import mmf.tacocloud.tacos.TacoOrder;
import mmf.tacocloud.tacos.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByUserOrderByPlacedAtDesc(User user);
}
