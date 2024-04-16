package com.student.register.StudentRegister.controller;

import com.student.register.StudentRegister.entities.Student;
import com.student.register.StudentRegister.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController
{
    private StudentService service;
    @Value("${gender}")
    private List<String> gender;

    @Value("${course}")
    private List<String> course;
    @Autowired
    public StudentController(StudentService service)
    {
        this.service=service;
    }

    @GetMapping("/showForm")
    public String showForm(Model model)
    {
        model.addAttribute("student", new Student());
        model.addAttribute("gender", gender);
        model.addAttribute("course",course);
        return "AddStudent";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model)
    {
        Student student = service.findStudentById(id);
        model.addAttribute("student",student);
        model.addAttribute("gender", gender);
        model.addAttribute("course",course);
        return "EditStudent";
    }
    @PostMapping("/insertStudent")
    public String saveStudent(@ModelAttribute("student") Student student)
    {
        service.saveStudent(student);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String getAllStudents(Model model)
    {
        List<Student> allStudents = service.getAllStudents();
        model.addAttribute("students", allStudents);
        return "StudentList";
    }

    @PostMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable("id") int id,
                                @ModelAttribute("student") Student student)
    {
        service.saveStudent(student);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudents(@PathVariable("id") int id)
    {
        service.deleteStudents(id);
        return "redirect:/list";
    }
}
