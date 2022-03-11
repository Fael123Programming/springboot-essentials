package com.rafael.springboot.controller;

import com.rafael.springboot.domain.car.Car;
import com.rafael.springboot.service.CarService;
import com.rafael.springboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import java.time.LocalDateTime;

@RestController
@RequestMapping("cars")
@Log4j2
@RequiredArgsConstructor
public class CarController {
    private final DateUtil dateUtil;
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(carService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Car> findById(@PathVariable long id) throws ResponseStatusException {
        return ResponseEntity.ok(carService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car) {
        return new ResponseEntity<>(carService.save(car), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) throws ResponseStatusException {
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Car car) throws ResponseStatusException {
        carService.replace(car);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
