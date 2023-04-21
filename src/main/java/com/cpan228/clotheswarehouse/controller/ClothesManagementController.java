package com.cpan228.clotheswarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cpan228.clotheswarehouse.repository.ItemRepository;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ClothesManagementController {

  @GetMapping("/clothes-management")
  public String getClothesManagementPage(Model model) {
    return "clothes-management";
  }

  @Autowired
  private ItemRepository itemRepository;

  @PostMapping("/clothes-management/delete/{id}")
  public String deleteItem(@PathVariable("id") Long id) {
    itemRepository.deleteById(id);
    return "redirect:/clothes-management";
  }
}