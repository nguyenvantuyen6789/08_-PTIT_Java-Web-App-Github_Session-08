package com.data.demo01_customer.controller;

import com.data.demo01_customer.model.Customer;
import com.data.demo01_customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("customer")
    public String findAll(Model model) {
        List<Customer> customers = customerService.findAll();
        System.out.println("Size: " + customers.size());
        // model truyen du lieu ra view
        model.addAttribute("customers", customers);

        return "customer"; // file customer.jsp
    }
}
