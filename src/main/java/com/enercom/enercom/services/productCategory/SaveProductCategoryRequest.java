package com.enercom.enercom.services.productCategory;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SaveProductCategoryRequest {
    private int id;
    @NotEmpty
    private String title;
}
