package com.example.demo.Api;

import com.example.demo.models.Student;
import com.example.demo.service.ServiceStrudentImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/Student")
@RestController
public class StudentController {

    private final ServiceStrudentImp service;
    @Autowired
    public StudentController( ServiceStrudentImp service) {
        this.service = service;
    }
    @PostMapping
public String addStudent(@RequestBody Student student){
        return service.SaveStudent(student);
}
@GetMapping()
public List<Student> getAll(){
       return service.GetStudents();
    }
    @GetMapping(path = "{id}")
    public Student findStudentById(@PathVariable("id") int id){
      return  service.GetStudentByID(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public String deleteStudent(@PathVariable("id") int id){
return service.DeleteStudentByID(id);
    }
    @PutMapping
    public String UpdateStudent(@RequestBody Student student){
      return   service.UpdateStudent(student);
}
}
