package com.example.spring_boot_product_seller.security;

import com.example.spring_boot_product_seller.security.jwt.JwtAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/**
 * @author ilkeryelekcioglu
 * @date 24.12.2024
 */

@Configuration
public class SecurityConfig {

  private final CustomUserDetailService customUserDetailService;

  public SecurityConfig(CustomUserDetailService customUserDetailService) {
    this.customUserDetailService = customUserDetailService;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable()) // CSRF'yi devre dışı bırak
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(new AntPathRequestMatcher("/api/authentication/**")).permitAll() // Public endpoints
            .anyRequest().authenticated() // Diğer tüm istekler kimlik doğrulaması gerektirir
        )
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless oturum yönetimi
        );

    http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }


  //Why don't we describe it as a component because of scope
  @Bean
  public JwtAuthorizationFilter jwtAuthorizationFilter(){
    return new JwtAuthorizationFilter();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}

