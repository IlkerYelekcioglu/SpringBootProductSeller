package com.example.spring_boot_product_seller.service;

import com.example.spring_boot_product_seller.model.Product;
import com.example.spring_boot_product_seller.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */
@Service
public class SimpleProductService implements ProductService {

    private ProductRepository productRepository;

  public SimpleProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product saveProduct(Product product) {
    product.setCreateTime(LocalDateTime.now());

    return productRepository.save(product);
  }
  @Override
  public void deleteProduct(Long id){
    productRepository.deleteById(id);
  }
  @Override
  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }
}
