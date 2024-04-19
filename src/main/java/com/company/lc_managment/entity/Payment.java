package com.company.lc_managment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double cost;
    @ManyToOne
    private  Student student;
    @ManyToOne
    private Group group;
    @Enumerated(EnumType.STRING)
    private Month month;

}
