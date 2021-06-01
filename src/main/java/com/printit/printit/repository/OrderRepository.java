package com.printit.printit.repository;

import com.printit.printit.models.OrderD;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderD, Long> {
}

