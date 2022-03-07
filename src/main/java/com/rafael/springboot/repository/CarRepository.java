package com.rafael.springboot.repository;

import com.rafael.springboot.domain.car.Car;

import java.util.List;

public interface CarRepository {
    List<Car> listAll();
}
