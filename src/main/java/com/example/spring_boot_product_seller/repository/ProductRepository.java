package com.example.spring_boot_product_seller.repository;

import com.example.spring_boot_product_seller.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
