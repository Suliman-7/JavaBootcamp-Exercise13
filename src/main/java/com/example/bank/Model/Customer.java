package com.example.bank.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {


    private String id ;
    private String username ;
    private double balance ;

}
