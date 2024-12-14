package com.example.spring_boot_product_seller.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */

@Entity
@Table(name = "USERS")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "USERNAME",unique = true, nullable = false,length = 100)
  private String username;

  @Column(name = "PASSWORD",nullable = false)
  private String password;

  @Column(name = "NAME",nullable = false)
  private String name;

  @Column(name = "CREATE_TIME",nullable = false)
  private LocalDateTime createTime;

  //role


}
