package com.example.spring_boot_product_seller.service;

import com.example.spring_boot_product_seller.model.Role;
import com.example.spring_boot_product_seller.model.User;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */
public interface UserService {

  User saveUser(User user);

  Optional<User> findUserByUsername(String username);

  @Transactional
  void changeRole(Role newRole, String username);
}
