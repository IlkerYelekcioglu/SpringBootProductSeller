package com.example.spring_boot_product_seller.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;


/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */

@Data
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
  @Enumerated(EnumType.STRING)
  @Column(name = "ROLE",nullable = false)
  private Role role;

  /*
  Eğer enumdan alınıcak bir değeri entity içerisine tanımladığımızda @Column hariç enumerated annotasyonunu kullanırız.
   */

}
