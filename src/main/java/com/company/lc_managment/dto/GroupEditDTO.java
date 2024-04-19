package com.company.lc_managment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupEditDTO {
    private Integer courseId;
    private String daysOfWeek;
    private String types;
    private  Integer  teacherId;
}
