package com.example.restapi.api;

import com.example.restapi.model.Student;
import com.example.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
//import java.util.UUID;

@RestController
@RequestMapping("api/v1/student")

public class StudentController {


    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }
    @PostMapping
    public void addStudent(@RequestBody  Student student){
        studentService.addStudent(student);

    }
    @GetMapping
    public List<Student> getAllStudents(){
       return studentService.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable("id") UUID id){
      return studentService.getStudentById(id)
              .orElse(null);


    }
    @DeleteMapping(path= "{id}")
    public void deleteStudent(@PathVariable("id") UUID id) {
         studentService.deleteStudent(id);

    }
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id,@RequestBody Student personToUpdate){
        studentService.updateStudent(id,personToUpdate);

    }

}
