package com.rafael.springboot.controller;

import com.rafael.springboot.domain.customer.Customer;
import com.rafael.springboot.service.CustomerService;
import com.rafael.springboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("customers") //The standard is to put the gate in plural form.
@Log4j2
@RequiredArgsConstructor //At the load time of this class, a constructor will be created automatically for all final attributes.
public class CustomerController {
    private final DateUtil dateUtil; //Dependency injection shall be done through a constructor only.
    private final CustomerService customerService;

    @GetMapping //localhost:8080/customers to access this method on a browser.
    public ResponseEntity<List<Customer>> list() {
//      With the following line at which request done a new log will be record in Spring log.
//      In this case, a simple timestamp.
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(customerService.listAll(), HttpStatus.OK);
//      return ResponseEntity.ok(customerService.listAll()); would also work fine.
//      A response entity contains the data to be returned and further information such as the http status of the
//      request. In this case, HttpStatus.OK is represented by the code 200.
    }

    @GetMapping(path = "/{id}") //localhost:8080/customers/id_number to access this method.
    public ResponseEntity<Customer> findById(@PathVariable long id) throws ResponseStatusException {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping //POST methods are for saving data into the server.
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
//      HttpStatus.CREATED is 201.
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) throws ResponseStatusException {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping //Method to replace the content of an existing object on the server.
    public ResponseEntity<Customer> replace(@RequestBody Customer customer) throws ResponseStatusException {
        customerService.replace(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
