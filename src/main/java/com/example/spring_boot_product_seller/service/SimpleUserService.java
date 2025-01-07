package com.example.spring_boot_product_seller.service;

import com.example.spring_boot_product_seller.model.Role;
import com.example.spring_boot_product_seller.model.User;
import com.example.spring_boot_product_seller.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */
@Service
public class SimpleUserService implements UserService {

  @Autowired
 private UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;
  public SimpleUserService(
   UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User saveUser(User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRole(Role.USER);
    user.setCreateTime(LocalDateTime.now());

    return userRepository.save(user);
  }

  @Override
  public Optional<User> findUserByUsername(String username){
    return userRepository.findByUsername(username);
  }

  @Override
  @Transactional //Transactional is required when executing update/delete query
  public void changeRole(Role newRole, String  username){
    userRepository.updateUserRole(username, newRole);
  }
}
