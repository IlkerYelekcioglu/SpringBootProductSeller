package com.example.spring_boot_product_seller.service;

import com.example.spring_boot_product_seller.model.Product;
import com.example.spring_boot_product_seller.model.Purchase;
import com.example.spring_boot_product_seller.repository.projection.PurchaseItem;
import java.util.List;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */
public interface PurchaseService {

  Purchase savePurchase(Purchase purchase);

  List<PurchaseItem> findAllPurchaseItemsOfUser(Long userId);
}
