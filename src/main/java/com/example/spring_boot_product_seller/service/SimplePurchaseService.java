package com.example.spring_boot_product_seller.service;

import com.example.spring_boot_product_seller.model.Purchase;
import com.example.spring_boot_product_seller.repository.PurchaseRepository;
import com.example.spring_boot_product_seller.repository.projection.PurchaseItem;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */
@Service
public class SimplePurchaseService implements PurchaseService {

  private PurchaseRepository purchaseRepository;

  public SimplePurchaseService(PurchaseRepository purchaseRepository) {
    this.purchaseRepository = purchaseRepository;
  }

  @Override
  public Purchase savePurchase(Purchase purchase) {
    purchase.setPurchaseTime(LocalDateTime.now());
    return purchaseRepository.save(purchase);
  }

  @Override
  public List<PurchaseItem> findAllPurchaseItemsOfUser(Long userId) {
   return purchaseRepository.findAllByPurchasesOfUser(userId);
  }
}
