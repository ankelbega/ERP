package com.enercom.enercom.services.product;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SaveProductRequest {
    private int id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private char type;
    @NotEmpty
    private int stock;
}
