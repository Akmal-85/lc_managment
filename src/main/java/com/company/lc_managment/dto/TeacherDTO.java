package com.company.lc_managment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDTO {
    private Long userId;
    private double salary;
    private int[] groupList;
    private LocalDate dateOfStartingWork;
}
