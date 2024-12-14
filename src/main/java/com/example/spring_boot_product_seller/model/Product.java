package com.example.spring_boot_product_seller.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */
@Data
@Entity
@Table(name = "PRODUCT")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "NAME",nullable = false)
  private String name;

  @Column(name = "DESCRIPTION",nullable = false)
  private String description;

  @Column(name = "PRICE",nullable = false)
  private String price;

  @Column(name = "CREATE_TIME",nullable = false)
  private LocalDateTime createTime;

//  @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
//  private Set<Purchase> purchaseList;
}
