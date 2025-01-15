package com.example.spring_boot_product_seller.controller;

import com.example.spring_boot_product_seller.model.Purchase;
import com.example.spring_boot_product_seller.security.UserPrinciple;
import com.example.spring_boot_product_seller.service.PurchaseService;
import java.nio.file.attribute.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ilkeryelekcioglu
 * @date 14.01.2025
 */

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {

  @Autowired
  private PurchaseService purchaseService;

  @PostMapping
  public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase) {
    return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
  }

  public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrinciple userPrinciple) {
    return ResponseEntity.ok(purchaseService.findAllPurchaseItemsOfUser(userPrinciple.getId()));
  }
}
