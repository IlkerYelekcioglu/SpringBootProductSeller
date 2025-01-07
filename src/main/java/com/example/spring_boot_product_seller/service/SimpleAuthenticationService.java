package com.example.spring_boot_product_seller.service;

import com.example.spring_boot_product_seller.model.User;
import com.example.spring_boot_product_seller.security.UserPrinciple;
import com.example.spring_boot_product_seller.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


/**
 * @author ilkeryelekcioglu
 * @date 01.01.2025
 */
@Service
public class SimpleAuthenticationService implements AuthenticationService {

  @Autowired
  private AuthenticationManager authenticationManager;

  private JwtProvider jwtProvider;

  @Override
  public User signInReturnJwt(User signInRequest){
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));

    UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
    String jwt = jwtProvider.generateToken(userPrinciple);

    User signInUser = userPrinciple.getUser();
    signInUser.setToken(jwt);

    return signInUser;
  }
}
