package com.fisa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
   private String name;
    private String currency;
    private double value;

    public Product(String name, double value) {
        this.name = name;
        this.value = value;
    }
}
