package com.cpan228.clotheswarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpan228.clotheswarehouse.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  User findByUsername(String username);
}
