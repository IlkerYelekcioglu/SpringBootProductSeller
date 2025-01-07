package com.example.spring_boot_product_seller.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

/**
 * @author ilkeryelekcioglu
 * @date 15.12.2024
 */
public class SecurityUtils {

  public static final String ROLE_PREFIX = "ROLE_";
  public static final String AUTH_HEADER = "authorization";
  public static final String AUTH_TOKEN_TYPE = "Bearer";
  public static final String AUTH_TOKEN_PREFIX = AUTH_TOKEN_TYPE + " ";

  public static SimpleGrantedAuthority convertToAuthority(String role){
    String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;

    return new SimpleGrantedAuthority(formattedRole);
  }

  public static String extractAuthTokenFromRequest(HttpServletRequest request){
    String bearerToken = request.getHeader(AUTH_HEADER);

    if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(AUTH_TOKEN_PREFIX)){
      return bearerToken.substring(7);
    }
    return null;
  }
}
