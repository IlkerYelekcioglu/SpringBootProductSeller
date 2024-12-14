package com.example.spring_boot_product_seller.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */
@Data
@Entity
@Table(name = "PURCHASE")
public class Purchase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "USER_ID",nullable = false)
  private Long userId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID",referencedColumnName = "id",insertable = false,updatable = false) // Bu sadece foreign key için
  private User user;

  @Column(name = "PRODUCT_ID",nullable = false)
  private Long productId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT_ID",referencedColumnName = "id",insertable = false,updatable = false)
  private Product product;

  @Column(name = "PURCHASE_TIME",nullable = false)
  private LocalDateTime purchaseTime;

  @Column(name = "PRICE",nullable = false)
  private String price;
}
