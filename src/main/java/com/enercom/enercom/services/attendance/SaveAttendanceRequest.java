package com.enercom.enercom.services.attendance;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class SaveAttendanceRequest {
    private int id;
    @NotEmpty
    private Date timeIn;
    @NotEmpty
    private Date timeOut;
    @NotEmpty
    private String remarks;

}
