package com.enercom.enercom.services.department;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SaveDepartmentRequest {
    private int id;
    @NotEmpty
    private String departmentName;
}
