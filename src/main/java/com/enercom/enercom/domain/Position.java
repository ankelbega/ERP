package com.enercom.enercom.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int positionId;
    private String positionName;

}
