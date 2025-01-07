package com.example.spring_boot_product_seller.service;


import com.example.spring_boot_product_seller.model.User;

/**
 * @author ilkeryelekcioglu
 * @date 01.01.2025
 */
public interface AuthenticationService {

  User signInReturnJwt(User signInRequest);
}
