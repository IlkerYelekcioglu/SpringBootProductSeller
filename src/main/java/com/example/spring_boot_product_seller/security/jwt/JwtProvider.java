package com.example.spring_boot_product_seller.security.jwt;

import com.example.spring_boot_product_seller.security.UserPrinciple;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

/**
 * @author ilkeryelekcioglu
 * @date 01.01.2025
 */

public interface JwtProvider {

  String generateToken(UserPrinciple auth);

  Authentication getAuthentication(HttpServletRequest request);

  boolean isTokenValid(HttpServletRequest request);
}
