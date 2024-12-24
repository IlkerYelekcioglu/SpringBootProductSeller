package com.example.spring_boot_product_seller.security;

import com.example.spring_boot_product_seller.model.User;
import com.example.spring_boot_product_seller.service.UserService;
import com.example.spring_boot_product_seller.utils.SecurityUtils;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ilkeryelekcioglu
 * @date 15.12.2024
 */
@Service
public class CustomUserDetailService implements UserDetailsService{

  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.findUserByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));

    Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));


    //UserDetail
    return UserPrinciple.builder()
        .user(user)
        .id(user.getId())
        .username(user.getUsername())
        .password(user.getPassword())
        .authorities(authorities)
        .build();
  }
}
