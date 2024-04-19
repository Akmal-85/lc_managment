package com.company.lc_managment.service;

import com.company.lc_managment.dto.PaymentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    PaymentDTO getPaymentByStudentIdAndMonth(Integer studentId, String month);

    List<PaymentDTO> getPaymentByGroupIdAndMonth(Integer groupId, String month);
}
