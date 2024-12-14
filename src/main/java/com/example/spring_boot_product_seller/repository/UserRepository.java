package com.example.spring_boot_product_seller.repository;


import com.example.spring_boot_product_seller.model.Role;
import com.example.spring_boot_product_seller.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author ilkeryelekcioglu
 * @date 14.12.2024
 */
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);

  @Modifying
  @Query("update User set role = :role where username = :username")
  void updateUserRole(@Param("username")String username,@Param("role") Role role);
}
