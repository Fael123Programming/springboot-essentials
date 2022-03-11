package com.rafael.springboot.service;

import com.rafael.springboot.domain.car.Car;
import com.rafael.springboot.domain.car.Color;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
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

    public Car findById(long id) throws ResponseStatusException {
        return cars.stream().
                filter(car -> car.getId() == id).
                findFirst().
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car with id " + id +
                        " does not exist"));
    }

    public Car save(Car car) {
        car.setId(ThreadLocalRandom.current().nextLong(4, 1000000));
        cars.add(car);
        return car;
    }

    public void delete(long id) throws ResponseStatusException {
        cars.remove(findById(id));
    }

    public void replace(Car car) throws ResponseStatusException {
        delete(car.getId());
        cars.add(car);
    }
}
