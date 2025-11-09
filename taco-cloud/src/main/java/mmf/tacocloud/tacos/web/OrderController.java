package mmf.tacocloud.tacos.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mmf.tacocloud.tacos.TacoOrder;
import mmf.tacocloud.tacos.User;
import mmf.tacocloud.tacos.data.OrderRepository;
import mmf.tacocloud.tacos.data.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final UserRepository userRepository;
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus, Principal principal) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        User user = userRepository.findByUsername(principal.getName());
        tacoOrder.setUser(user);
        log.info("Order submitted {}", tacoOrder);
        orderRepository.save(tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
