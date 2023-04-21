package com.cpan228.clotheswarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cpan228.clotheswarehouse.controller.DesignController;

@SpringBootApplication
public class ClotheswarehouseApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ClotheswarehouseApplication.class, args);

		DesignController controller = context.getBean(DesignController.class);
	}

}
