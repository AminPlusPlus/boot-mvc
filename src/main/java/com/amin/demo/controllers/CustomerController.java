package com.amin.demo.controllers;


import com.amin.demo.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @RequestMapping("/showForm")
    public String showForm(Model model){

        model.addAttribute("customer",new Customer());
        return  "showform";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult result){

        return (result.hasErrors()) ? "showform" : "confirm";

    }
}
