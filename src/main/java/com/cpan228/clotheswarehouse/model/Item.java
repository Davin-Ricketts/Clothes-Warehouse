package com.cpan228.clotheswarehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Item {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private String brand;

    @PositiveOrZero
    @Min(value = 2022, message = "Year of creation must be 2022 or greater")
    private int yearOfCreation;

    @PositiveOrZero
    @Min(value = 1000, message = "Price must be 1000 or greater")
    private double price;

    public enum Brand {
        BALENCIAGA,
        STONE_ISLAND,
        DIOR
    }
}

