package com.company.lc_managment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {

    private double cost;
    private String studentName;
    private Integer groupId;
    private Month month;

}
