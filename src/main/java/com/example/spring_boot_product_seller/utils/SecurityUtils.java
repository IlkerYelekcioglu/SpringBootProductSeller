package com.example.spring_boot_product_seller.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author ilkeryelekcioglu
 * @date 15.12.2024
 */
public class SecurityUtils {

  public static final String ROLE_PREFIX = "ROLE_";

  public static SimpleGrantedAuthority convertToAuthority(String role){
    String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;

    return new SimpleGrantedAuthority(formattedRole);
  }
}
