package com.cpan228.clotheswarehouse.repository;

import com.cpan228.clotheswarehouse.model.Item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
  List<Item> findByBrandAndYear(String brand, int year);
    
  @Query("SELECT i FROM Item i ORDER BY i.brand")
  List<Item> findAllOrderByBrand();
}