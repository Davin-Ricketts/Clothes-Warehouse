package com.cpan228.clotheswarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.cpan228.clotheswarehouse.model.Item.Brand;

import com.cpan228.clotheswarehouse.model.Item;
import com.cpan228.clotheswarehouse.repository.ItemRepository;
import com.cpan228.clotheswarehouse.model.Item;

@SpringBootApplication
public class ClotheswarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClotheswarehouseApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ItemRepository repository) {
		return args -> {
			repository.save(Item.builder().name("T-Shirt").brand(Brand.BALENCIAGA).yearOfCreation(2023).price(1000.00).build());

			repository.save(Item.builder().name("Sweater").brand(Brand.DIOR).yearOfCreation(2023).price(2000.00).build());

			repository.save(Item.builder().name("Pants").brand(Brand.STONE_ISLAND).yearOfCreation(2023).price(1500.00).build());
		};
	}

}
