package com.example.productstage.DTOs;

import lombok.Data;

@Data
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private double unitPrice;
    private int quantity;
}
