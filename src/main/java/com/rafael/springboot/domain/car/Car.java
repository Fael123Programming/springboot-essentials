package com.rafael.springboot.domain.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Car {
    private String brand, model;
    private Color color;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
