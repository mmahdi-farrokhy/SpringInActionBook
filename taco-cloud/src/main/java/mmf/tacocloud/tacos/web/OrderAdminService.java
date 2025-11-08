package mmf.tacocloud.tacos.web;

import mmf.tacocloud.tacos.data.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderAdminService {
    private final OrderRepository orderRepository;

    public OrderAdminService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
