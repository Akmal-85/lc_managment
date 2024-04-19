package com.company.lc_managment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private  User user;
    @ManyToOne
    private Group [] groups;
    private double salary;
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate dateOfStartingWork;



}
