package com.cpan228.clotheswarehouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "items")
public class Item {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Brand brand;

    @PositiveOrZero
    @Min(value = 2022, message = "Year of creation must be 2022 or greater")
    @Column(nullable = false)
    private int yearOfCreation;

    @PositiveOrZero
    @Min(value = 1000, message = "Price must be 1000 or greater")
    @Column(nullable = false)
    private double price;

    public enum Brand {
        BALENCIAGA("Balenciaga"),
        STONE_ISLAND("Stone Island"),
        DIOR("Dior");

        private String title;

        private Brand(String title) {
            this.title = title;
        }

        private String getBrand() {
            return title;
        }

        public static boolean isValidBrand(Brand brand) {
            for (Brand b : Brand.values()) {
                if (b == brand) {
                    return true;
                }
            }
            return false;
        }
    }
}

