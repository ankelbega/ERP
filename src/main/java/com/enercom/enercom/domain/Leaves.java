package com.enercom.enercom.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Leaves")
public class Leaves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private Date startDate;
    private Date endDate;
    private int totalDays;


}
