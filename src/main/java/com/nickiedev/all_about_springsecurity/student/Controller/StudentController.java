package com.nickiedev.all_about_springsecurity.student.Controller;

import com.nickiedev.all_about_springsecurity.student.entities.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private static final List <Student> STUDENTS = Arrays.asList(
            new Student(1, "Nicholas Nzovia"),
            new Student(2, "Fidelis Mueni"),
            new Student(3, "Cicilia Nduge")

    );
    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return  STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst().orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist")) ;
    }

}
