package org.mmf.chapter7.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.mmf.chapter7.TacoOrder;
import org.mmf.chapter7.User;
import org.mmf.chapter7.data.OrderRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderProps props;
    private OrderRepository orderRepository;

    public OrderController(OrderProps props, OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.props = props;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        tacoOrder.setUser(user);
        log.info("Order submitted {}", tacoOrder);
        orderRepository.save(tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model) {
        Pageable pageable = PageRequest.of(0, props.getPageSize());
        List<TacoOrder> orders = orderRepository.findByUserOrderByPlacedAtDesc(user, pageable);

        model.addAttribute("orders", orders);
        return "orderList";
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder putOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder tacoOrder) {
        tacoOrder.setId(orderId);
        return orderRepository.save(tacoOrder);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder patchOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder patch) {
        TacoOrder order = orderRepository.findById(orderId).get();

        String patchDeliveryName = patch.getDeliveryName();
        if (patchDeliveryName != null) {
            order.setDeliveryName(patchDeliveryName);
        }

        String patchDeliveryStreet = patch.getDeliveryStreet();
        if (patchDeliveryStreet != null) {
            order.setDeliveryStreet(patchDeliveryStreet);
        }

        String patchDeliveryCity = patch.getDeliveryCity();
        if (patchDeliveryCity != null) {
            order.setDeliveryCity(patchDeliveryCity);
        }

        String patchDeliveryState = patch.getDeliveryState();
        if (patchDeliveryState != null) {
            order.setDeliveryState(patchDeliveryState);
        }

        String patchDeliveryZip = patch.getDeliveryZip();
        if (patchDeliveryZip != null) {
            order.setDeliveryZip(patchDeliveryZip);
        }

        String patchCcNumber = patch.getCcNumber();
        if (patchCcNumber != null) {
            order.setCcNumber(patchCcNumber);
        }

        String patchCcExpiration = patch.getCcExpiration();
        if (patchCcExpiration != null) {
            order.setCcExpiration(patchCcExpiration);
        }

        String patchCcCVV = patch.getCcCVV();
        if (patchCcCVV != null) {
            order.setCcCVV(patchCcCVV);
        }

        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            orderRepository.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
