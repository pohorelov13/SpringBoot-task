package demo.service;

import demo.model.Order;
import demo.model.Product;
import demo.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderJpaService implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order add(Order order) {
        double cost = 0;
        for (Product p : order.getProducts()) {
            p.setOrder(order);
            cost += p.getCost();
        }
        order.setCost(cost);
        return orderRepository.add(order);
    }

    @Override
    public Order getById(int id) {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }
}
