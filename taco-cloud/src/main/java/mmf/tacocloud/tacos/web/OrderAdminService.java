package mmf.tacocloud.tacos.web;

import mmf.tacocloud.tacos.TacoOrder;
import mmf.tacocloud.tacos.data.OrderRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderAdminService {
    private final OrderRepository orderRepository;

    public OrderAdminService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    @PostAuthorize("hasRole('ADMIN') || returnObject.user.userName == authentication.name")
    public TacoOrder getOrder(Long id) {
        Optional<TacoOrder> tacoById = orderRepository.findById(id);

        if (tacoById.isEmpty()) {
            throw new RuntimeException("Order not found");
        }

        return tacoById.get();
    }
}
