package com.example.spring_boot_product_seller.controller;

import com.example.spring_boot_product_seller.model.Role;
import com.example.spring_boot_product_seller.security.UserPrinciple;
import com.example.spring_boot_product_seller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ilkeryelekcioglu
 * @date 14.01.2025
 */

@RestController
@RequestMapping("api/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PutMapping("change/{role}")
  public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrinciple userPrinciple,
      @PathVariable Role role) {
    userService.changeRole(role, userPrinciple.getUsername());
    return ResponseEntity.ok(true);
  }
}
