package com.enercom.enercom.services.education;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class SaveEducationRequest {
    private int id;
    @NotEmpty
    private String degree;
    @NotEmpty
    private Date startDate;
    @NotEmpty
    private Date endDate;
    @NotEmpty
    private String skills;
    @NotEmpty
    private String trainings;
}
