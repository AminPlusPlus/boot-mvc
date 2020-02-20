package com.amin.demo.controllers;

import com.amin.demo.models.Student;
import com.amin.demo.repositories.StudentRepository;
import com.amin.demo.services.StudentService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService repository;


    LocalSessionFactoryBean sessionFactory;

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

        repository.save(student);

        return "student-confirmation";

    }

    @RequestMapping("/searchStudent")
    public String searchStudentId(){

        System.out.println(repository.getListByLastName("Abdullozoda").toString());

        return "getStudent";
    }

    @RequestMapping("/resultSearchStudent")
    public String searchStudentId(@RequestParam("searchId") String id, Model model ){

        Long id_user = Long.parseLong(id);
        Optional<Student> studentOptional = repository.findById(id_user);

        model.addAttribute("resultStudent",studentOptional.isPresent() ? studentOptional.get() : "Not Exist" );


        return "getStudent";
    }
}
