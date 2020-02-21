package com.amin.demo.repositories;

import com.amin.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //Get students list by the name
    @Query(value = "from Student s where s.lastName = :lastName ")
    List<Student> getStudentByLastName(@Param("lastName") String lastName );


    //Update all student emails
    @Query(value = "update Student set email = :email")
    void updateAllStudentEmails(@Param("email") String email);
}
