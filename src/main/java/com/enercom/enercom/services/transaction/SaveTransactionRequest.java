package com.enercom.enercom.services.transaction;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SaveTransactionRequest {
    private int id;
    @NotEmpty
    private char code;
    @NotEmpty
    private int state;
}
