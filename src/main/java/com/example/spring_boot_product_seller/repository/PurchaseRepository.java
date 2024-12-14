package com.example.spring_boot_product_seller.repository;

import com.example.spring_boot_product_seller.model.Purchase;
import com.example.spring_boot_product_seller.repository.projection.PurchaseItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

  @Query("select prd.name as name,pur.price as price, pur.purchaseTime as purchaseTime from Purchase  pur left join Product prd on prd.id = pur.id where pur.userId = :userId")
  List<PurchaseItem> findAllByPurchasesOfUSer(@Param("userId") Long userId);
}
