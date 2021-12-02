package com.enercom.enercom.services.employee;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class SaveEmployeeRequest {
    private int empId;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private Date birthDate;
    private int age;
    @NotEmpty
    private char gender;
    @NotEmpty
    private String address;
    @NotEmpty
    private Date employedDate;

}
