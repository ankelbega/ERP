package com.enercom.enercom.services.position;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SavePositionRequest {
    private int positionId;
    @NotEmpty
    private String positionName;
}
