package com.enercom.enercom.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String  entityName;
    private char stockUnit;
    private int maxRetailPrice;
    private float entryPrice;
    private  float finalPrice;
    private float tvsh;

    private Date registeredAt;
    private LocalDateTime updatedAt;
}
