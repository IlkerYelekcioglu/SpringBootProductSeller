package com.example.spring_boot_product_seller.service;

import com.example.spring_boot_product_seller.model.Product;
import java.util.List;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */
public interface ProductService {

  Product saveProduct(Product product);

  void deleteProduct(Long id);

  List<Product> findAllProducts();
}
