package com.rafael.springboot.service;

import com.rafael.springboot.domain.car.Car;
import com.rafael.springboot.domain.car.Color;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CarService {
//    private final CarRepository carRepository;
    private static final List<Car> cars;

    static {
        cars = new ArrayList<>(List.of(new Car("Chevrolet", "Camaro SS", Color.BLACK, 1),
                new Car("Ferrari", "458 Italia", Color.RED, 2), new Car("Ford", "Mustang",
                        Color.WHITE, 3)));
    }

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

    public Car save(Car car) {
        car.setId(ThreadLocalRandom.current().nextLong(4, 1000000));
        cars.add(car);
        return car;
    }

    public boolean delete(long id) {
        Car carToDelete = findById(id);
        if (carToDelete == null)
            return false; //It didn't exist so throw a ResponseStatusException on the controller.
        return cars.remove(carToDelete);
    }
}
