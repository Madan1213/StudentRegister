package com.student.register.StudentRegister.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotEmpty(message="Name is required")
    private String name;


    @Column(name="phone")
    @NotEmpty(message = "Phone No is required")
    @Size(min = 10, max = 10)
    private String phone;

    @NotNull(message = "Please Select Gender")
    @Column(name="gender")
    private String gender;


    @Column(name="course")
    @NotEmpty(message = "Please select Course")
    private String course;

    @Column(name="location")
    @NotEmpty(message = "Please enter Location")
    private String location;

}

