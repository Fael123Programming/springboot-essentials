package com.rafael.springboot.domain.car;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private String brand, model;
    private Color color;
    private long id;
}
