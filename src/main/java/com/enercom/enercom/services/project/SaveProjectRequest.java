package com.enercom.enercom.services.project;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class SaveProjectRequest {
    private int id;
    @NotEmpty
    private String projectHandled;
    @NotEmpty
    private Date dateStarted;
    @NotEmpty
    private Date dateEnded;
    @NotEmpty
    private char status;
}
