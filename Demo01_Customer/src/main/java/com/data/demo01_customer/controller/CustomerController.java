package com.data.demo01_customer.controller;

import com.data.demo01_customer.model.Customer;
import com.data.demo01_customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("customer/{id}")
    public String findById(Model model,
                           @PathVariable Integer id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);

        return "customer_detail"; // file customer_detail.jsp
    }

    @GetMapping("search")
    public String search(@RequestParam(required = false) String fullName,
                         @RequestParam(required = false) String email,
                         Model model) {
        List<Customer> customers;
        if ((fullName == null || fullName.isEmpty()) && email == null || email.isEmpty()) {
            customers = customerService.findAll();
        } else {
            customers = customerService.search(fullName, email);
        }
        model.addAttribute("customers", customers);
        return "customer";
    }

    @GetMapping("customer-add")
    public String add() {
        return "customer_add"; // file customer_add.jsp
    }

    @PostMapping("customer-save")
    public String save(@RequestParam String fullName,
                       @RequestParam String email,
                       @RequestParam String gender,
                       @RequestParam String customerType) {
        Customer customer = new Customer();
        customer.setFullName(fullName);
        customer.setEmail(email);
        customer.setGender(gender);
        customer.setCustomerType(customerType);

        boolean result = customerService.save(customer);

        if (!result) {
            return "customer_add";
        } else {
            return "redirect:/customer";
        }
    }

    @GetMapping("customer-delete/{id}")
    public String delete(@PathVariable Integer id) {
        // thực thi xoá customer theo id
        boolean result = customerService.delete(id);

//        List<Customer> customers = customerService.findAll();
//        model.addAttribute("customers", customers);
//        return "customer"; // chuyển về trang customer.jsp

        // khuyến khích
        // chuyển về path /customer (CustomerController-> /customer)
        return "redirect:/customer";
    }

    @GetMapping("customer-edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Customer customer = customerService.findById(id);

        model.addAttribute("customer", customer);

        return "customer_edit"; // chuyển sang trang customer_edit.jsp
    }
}
