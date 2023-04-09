package demo.controller;

import demo.model.Order;
import demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public @ResponseBody Order getById(@PathVariable(name = "id") int id) {
        return orderService.getById(id);
    }

    @GetMapping
    public @ResponseBody List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping
    public @ResponseBody Order add(@RequestBody Order order) {
        return orderService.add(order);
    }
}
