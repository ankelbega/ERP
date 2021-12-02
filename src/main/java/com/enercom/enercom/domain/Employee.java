package com.enercom.enercom.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int empId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int age;
    private char gender;
    private String address;
    private Date employedDate;
}
