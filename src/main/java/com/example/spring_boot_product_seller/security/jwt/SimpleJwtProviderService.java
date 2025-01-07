package com.example.spring_boot_product_seller.security.jwt;


import com.example.spring_boot_product_seller.security.UserPrinciple;
import com.example.spring_boot_product_seller.utils.SecurityUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author ilkeryelekcioglu
 * @date 01.01.2025
 */
@Component
public class SimpleJwtProviderService implements JwtProvider
{
  @Value("${app.jwt.secret}")
  private String JWT_SECRET;

  @Value("${app.jwt.expiration-in-ms}")
  private Long JWT_EXPIRATION_IN_MS;


  @Override
  public String generateToken(UserPrinciple auth){
    String authorities = auth.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority).collect(
        Collectors.joining(","));

    Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

    return Jwts.builder()
        .setSubject(auth.getUsername())
        .claim("roles",authorities)
        .claim("userId",auth.getId())
        .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_IN_MS))
        .signWith(key, SignatureAlgorithm.HS512)
        .compact();
  }

  @Override
  public Authentication getAuthentication(HttpServletRequest request){
    Claims claims = extractClaims(request);
    if(claims == null){
      return null;
    }

    String username = claims.getSubject();
    Long userId = claims.get("userId", Long.class);

    Set<GrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
        .map(SecurityUtils::convertToAuthority)
        .collect(Collectors.toSet());

    UserDetails userDetails = UserPrinciple.builder()
        .username(username)
        .authorities(authorities)
        .id(userId)
        .build();
    if(username == null){
      return null;
    }
    return new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
  }

  @Override
  public boolean isTokenValid(HttpServletRequest request){
    Claims claims = extractClaims(request);

    if(claims == null){
      return false;
    }

    if(claims.getExpiration().before(new Date())){
      return false;
    }
    return true;
  }

  private Claims extractClaims(HttpServletRequest request)
  {
    //extractToken
    String token = SecurityUtils.extractAuthTokenFromRequest(request);
    if(token == null){
      return null;
    }
    Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

    return Jwts.parser()
        .setSigningKey(key)
        .build().
        parseClaimsJws(token)
        .getBody();
  }
}
