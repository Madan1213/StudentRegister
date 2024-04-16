package com.student.register.StudentRegister.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="phone")
    private String phone;
    @Column(name="gender")
    private String gender;
    @Column(name="course")
    private String course;
    @Column(name="location")
    private String location;

}

