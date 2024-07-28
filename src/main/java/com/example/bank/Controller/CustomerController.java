package com.example.bank.Controller;


import com.example.bank.Api.ApiResponse;
import com.example.bank.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class CustomerController {

    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }

    @PostMapping("/post")
    public ApiResponse addCustomers(@RequestBody Customer customer) {
        customers.add(customer);
        return new ApiResponse("customer added","200");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateCustomer(@PathVariable int index, @RequestBody Customer customer) {
        customers.set(index, customer);
        return new ApiResponse("customer data updated","200");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteCustomer(@PathVariable int index) {
        customers.remove(index);
        return new ApiResponse("customer deleted","200");
    }

    @PutMapping("/deposit/{index}/{amount}")
    public ApiResponse depositCustomer(@PathVariable int index, @PathVariable double amount) {
        customers.get(index).setBalance(customers.get(index).getBalance()+amount);
        return new ApiResponse("amount deposited successfully","200");
    }

    @PutMapping("/withdraw/{index}/{amount}")
    public ApiResponse withdrawCustomer(@PathVariable int index, @PathVariable double amount) {
        if(customers.get(index).getBalance()>=amount) {
            customers.get(index).setBalance(customers.get(index).getBalance()-amount);
            return new ApiResponse("amount withdrawn successfully","200");
        }
        else {
            return new ApiResponse("insufficient balance","400");
        }
    }




}
