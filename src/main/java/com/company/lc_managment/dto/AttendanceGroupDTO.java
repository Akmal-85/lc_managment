package com.company.lc_managment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AttendanceGroupDTO {
    private List<String> studentNames;
    private int groupId;
    private LocalDate date;
    private boolean check;

}
