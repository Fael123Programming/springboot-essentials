package com.rafael.springboot.controller;

import com.rafael.springboot.domain.Customer;
import com.rafael.springboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("customer")
@Log4j2
@RequiredArgsConstructor //At the load time of this class, a constructor will be created automatically for all final attributes.
public class CustomerController {
    private final DateUtil dateUtil; //Dependency injection shall be done through a constructor only.
    private final List<Customer> customers = List.of(new Customer("Pietro", 1), new Customer("Mary", 2)
            , new Customer("Rafael", 3));

    @GetMapping(path = "list") //localhost:8080/customer/list to access this method on a browser.
    public List<Customer> list() {
//      With the following line at which request done a new log will be record in Spring log.
//      In this case, a simple timestamp.
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return customers;
    }

    @GetMapping
    public Customer getCustomerById(@RequestParam(value = "id", defaultValue = "1") int id) {
        if (id <= 0 || id > customers.size())
            return null;
        return customers.get(id - 1);
    }
}
