package com.amin.demo.controllers;

import com.amin.demo.models.Student;
import com.amin.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository repository;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,editor);
    }

    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("student",new Student());
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Validated @ModelAttribute("student") Student student, BindingResult bindingResult){

        System.out.println(student);
        if ((bindingResult.hasErrors()))
            return "student-form";

        //TODO: save to db
        repository.saveAndFlush(student);

        return "student-confirmation";


    }
}
