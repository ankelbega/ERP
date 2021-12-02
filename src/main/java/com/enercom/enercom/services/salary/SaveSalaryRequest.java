package com.enercom.enercom.services.salary;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SaveSalaryRequest {
    private int empId;
    @NotEmpty
    private char salaryRange;
    @NotEmpty
    private double annualIncome;
    @NotEmpty
    private double insurance;
    @NotEmpty
    private double loans;
}
