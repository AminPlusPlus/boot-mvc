package com.amin.demo.controllers;


import com.amin.demo.models.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("customer")
public class CustomerController {


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        System.out.println("INIT Binder");
        //Editor
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        //Register it to class editor
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

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
