package com.example.spring_boot_product_seller.controller;


import com.example.spring_boot_product_seller.model.User;
import com.example.spring_boot_product_seller.service.AuthenticationService;
import com.example.spring_boot_product_seller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ilkeryelekcioglu
 * @date 01.01.2025
 */

@RestController
@RequestMapping("/api/authentication")//pre-path
public class AuthenticationController {

  @Autowired
  private AuthenticationService authenticationService;

  @Autowired
  private UserService userService;

  @PostMapping("/sign-up")
  public ResponseEntity<?> signUp(@RequestBody User user) {
    if(userService.findUserByUsername(user.getUsername()).isPresent()) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
  }
  @PostMapping("/sign-in")
  public ResponseEntity<?> signIn(@RequestBody User user) {
    return new ResponseEntity<>(authenticationService.signInReturnJwt(user), HttpStatus.OK);
  }
}
