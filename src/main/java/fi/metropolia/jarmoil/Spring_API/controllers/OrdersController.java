package fi.metropolia.jarmoil.Spring_API.controllers;

import fi.metropolia.jarmoil.Spring_API.repository.OrdersRepository;
import fi.metropolia.jarmoil.Spring_API.entity.Orders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrdersRepository repository;

    public OrdersController(OrdersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Integer id) {
//        OrderDto dto = orderService.getOrderDto(id);
//        if (dto == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(dto);

        return repository.findById(Long.valueOf(id))
                .map(order -> ResponseEntity.ok(order))
                .orElse(ResponseEntity.notFound().build());
    }
}
