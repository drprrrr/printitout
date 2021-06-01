package com.printit.printit.models;

import  com.printit.printit.OrderNotFoundException;
import com.printit.printit.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/letters")
    List<OrderD> all() {
        return (List<OrderD>) repository.findAll();
    }

    @GetMapping("/letters/{id}")
    OrderD one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @PostMapping("/letters")
    OrderD newPost(@RequestBody OrderD newOrd) {
        return repository.save(newOrd);
    }

    @PutMapping("/letters/{id}")
    OrderD put(@RequestBody OrderD replaceOrder, @PathVariable Long id) {
        return repository.findById(id).map(order -> {
            order = replaceOrder;
            order.setId(id);
            return repository.save(order);
        }).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @DeleteMapping("/letters/{id}")
    void del(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
