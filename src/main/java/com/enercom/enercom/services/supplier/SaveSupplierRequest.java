package com.enercom.enercom.services.supplier;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SaveSupplierRequest {
    private int id;
    @NotEmpty
    private String entityName;
    @NotEmpty
    private String address;
    @NotEmpty
    private int nipt;
    @NotEmpty
    private String city;
    @NotEmpty
    private int zipCode;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private long mobile;
    @NotEmpty
    private String email;
}
