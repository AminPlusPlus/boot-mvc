package com.amin.demo.services;

import com.amin.demo.models.Student;
import com.amin.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService  {

    @Autowired
    StudentRepository repository;

    public List<Student> getListByLastName(String lastName){
        return repository.getStudentByLastName(lastName);
    }

    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    public Student save(Student profile) {
        return repository.save(profile);
    }

   

}
