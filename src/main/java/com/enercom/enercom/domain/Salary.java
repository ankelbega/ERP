package com.enercom.enercom.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int empId;
    private char salaryRange;
    private double annualIncome;
    private double insurance;
    private double loans;
}
