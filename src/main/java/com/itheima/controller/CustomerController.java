package com.itheima.controller;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "list";
    }

    @RequestMapping("/updateUI")
    public String updateUI(Integer id,Model model){

        Customer customer = customerService.findCustomerById(id);
        System.out.println(customer);

        model.addAttribute("customer",customer);

        return "edit";
    }

    @RequestMapping("/update")
    public String update(Customer customer){
        customerService.updateCustomer(customer);

        return "redirect:/customer/findAll";
    }

    //添加用户UI
    @RequestMapping("/addUI")
    public String addUI(){

        return "add";
    }
    @RequestMapping("/add")
    public String add(Customer customer){

        customerService.saveCustomer(customer);
        return "redirect:/customer/findAll";

    }
}
