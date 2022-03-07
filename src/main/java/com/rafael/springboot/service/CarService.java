package com.rafael.springboot.service;

import com.rafael.springboot.domain.car.Car;
import com.rafael.springboot.domain.car.Color;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarService {
//    private final CarRepository carRepository;
    private final List<Car> cars = List.of(new Car("Chevrolet", "Camaro SS", Color.BLACK, 1),
            new Car("Ferrari", "458 Italia", Color.RED, 2), new Car("Ford", "Mustang",
                    Color.WHITE, 3));

    public List<Car> listAll() {
        return cars;
    }

    public Car findById(long id) {
        Car wanted;
        try {
            wanted = cars.stream().filter(car -> car.getId() == id).findFirst().get();
        } catch(NoSuchElementException ignore) {
            wanted = null;
        }
        return wanted;
    }
}
