package com.practice.boundedContext.market.out;

import com.practice.boundedContext.market.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
