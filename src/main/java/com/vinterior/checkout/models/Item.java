package com.vinterior.checkout.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {

    private int productCode;

    private String name;

    private double price;
}
