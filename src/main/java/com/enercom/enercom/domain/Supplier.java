package com.enercom.enercom.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String entityName;
    private String address;
    private int nipt;
    private String city;
    private int zipCode;
    private String firstName;
    private String lastName;
    private long mobile;
    private String email;
    private LocalDate registeredAt;
    private LocalDateTime updatedAt;


}
