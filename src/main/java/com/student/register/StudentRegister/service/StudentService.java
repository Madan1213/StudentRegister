package com.student.register.StudentRegister.service;

import com.student.register.StudentRegister.entities.Student;
import com.student.register.StudentRegister.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository)
    {
        this.repository=repository;
    }

    public Student saveStudent(Student student)
    {
        return repository.save(student);
    }

    public List<Student> getAllStudents()
    {
        return repository.findAll();
    }

    public void deleteStudents(int id)
    {
        repository.deleteById(id);
    }

    public Student findStudentById(int id)
    {
        return repository.findById(id).orElseThrow();
    }
}
