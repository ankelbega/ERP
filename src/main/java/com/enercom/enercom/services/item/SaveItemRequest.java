package com.enercom.enercom.services.item;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SaveItemRequest {
    private int id;
    @NotEmpty
    private String entityName;
    @NotEmpty
    private char stockUnit;
    @NotEmpty
    private int maxRetailPrice;
    @NotEmpty
    private float entryPrice;
    @NotEmpty
    private float finalPrice;
    @NotEmpty
    private float tvsh;


}
