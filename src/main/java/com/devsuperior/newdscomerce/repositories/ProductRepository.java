package com.devsuperior.newdscomerce.repositories;

import com.devsuperior.newdscomerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
