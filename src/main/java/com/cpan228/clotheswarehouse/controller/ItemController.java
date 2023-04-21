package com.cpan228.clotheswarehouse.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cpan228.clotheswarehouse.model.Item;
import com.cpan228.clotheswarehouse.model.Item.Brand;
import com.cpan228.clotheswarehouse.repository.ItemRepository;

@Controller
public class ItemController {

    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/list")
    public String itemList(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "list";
    }

    @GetMapping("/add-item")
    public String addItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "add-item";
    }

    @PostMapping("/add-item")
    public String addItemSubmit(@ModelAttribute Item item, Model model) {
        if (item.getPrice() < 1000) {
            model.addAttribute("errorMessage", "Price should be greater than 1000");
            return "add-item";
        }
        if (!Brand.isValidBrand(item.getBrand())) {
            model.addAttribute("errorMessage", "Invalid brand");
            return "add-item";
        }
        if (item.getYearOfCreation() <= 2021) {
            model.addAttribute("errorMessage", "Year of creation should be greater than 2021");
            return "add-item";
        }
        itemRepository.save(item);
        return "redirect:/list";
    }

    @PostMapping("/items/sortByBrand")
    public String sortByBrand(Model model) {
        List<Item> items = itemRepository.findAllOrderByBrand();
        model.addAttribute("items", items);
        return "list";
    }

}
