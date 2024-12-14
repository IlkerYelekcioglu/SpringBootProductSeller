package com.example.spring_boot_product_seller.repository.projection;

import java.time.LocalDateTime;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */
public interface PurchaseItem {
   String getName();
   Double getPrice();
   LocalDateTime getPurchaseTime();
}
