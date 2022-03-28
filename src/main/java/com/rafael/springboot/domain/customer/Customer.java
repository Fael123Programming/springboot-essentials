package com.rafael.springboot.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data //To provide this class with all auxiliary methods (such as getters, setters, toString, equals etc).
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Customer {
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
