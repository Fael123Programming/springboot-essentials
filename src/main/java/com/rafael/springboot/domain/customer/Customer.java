package com.rafael.springboot.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //To provide this class with all auxiliary methods (such as getters, setters, toString, equals etc).
@AllArgsConstructor
public class Customer {
    private String name;
    private long id;
}
