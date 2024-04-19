package com.company.lc_managment.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Student student;
    @OneToOne
    private Group group;
    private LocalDate date;
    @Column(columnDefinition = "boolean default false", name = "is_checked") // change column name to avoid reserved keyword
    private boolean isChecked; // change variable
}
