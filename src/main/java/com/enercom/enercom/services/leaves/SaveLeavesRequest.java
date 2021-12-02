package com.enercom.enercom.services.leaves;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class SaveLeavesRequest {
    private int id;
    @NotEmpty
    private Date startDate;
    @NotEmpty
    private Date endDate;
    @NotEmpty
    private int totalDays;
}
