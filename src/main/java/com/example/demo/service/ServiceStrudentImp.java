package com.example.demo.service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.models.Student;
import org.hibernate.service.UnknownUnwrapTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceStrudentImp {

private StudentRepository repository;
@Autowired
    public ServiceStrudentImp(StudentRepository repository) {
        this.repository = repository;
    }
    public String SaveStudent(Student student){
    repository.save(student);
   return "Student Added succesfully";
    }
    public List<Student> SaveStudents(List<Student> students){
    return repository.saveAll(students);
    }
public List<Student> GetStudents(){
    return repository.findAll();
}
public Optional<Student> GetStudentByID(int id){
    return repository.findById(id);
}
public String DeleteStudentByID(int id){
    repository.deleteById(id);
    return "Student was deleted succesfully !!";
}
public String UpdateStudent(Student student){
    Student existingStudent = repository.findById(student.getId()).orElse(null);
    existingStudent.setFirstname(student.getFirstname());
    existingStudent.setLastname(student.getLastname());
    existingStudent.setEmail(student.getEmail());
    repository.save(existingStudent);
    return "Update Completed Succesfully";
}
}
