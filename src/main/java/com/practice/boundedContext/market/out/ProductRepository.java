package com.practice.boundedContext.market.out;

import com.practice.boundedContext.market.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
