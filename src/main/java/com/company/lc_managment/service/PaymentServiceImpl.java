package com.company.lc_managment.service;

import com.company.lc_managment.dto.PaymentDTO;
import com.company.lc_managment.entity.Payment;
import com.company.lc_managment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;

import java.time.Month;
import java.util.List;

@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    @Override
    public PaymentDTO getPaymentByStudentIdAndMonth(Integer studentId, String month) {
        Payment byStudentIdAndMonth = paymentRepository.findByStudentIdAndMonth(Long.valueOf(studentId), Month.valueOf(month));
        return mapToPayment(byStudentIdAndMonth);
    }


    @Override
    public List<PaymentDTO> getPaymentByGroupIdAndMonth(Integer groupId, String month) {
        List<Payment> byGroupIdAndMonth = paymentRepository.findByGroup_IdAndMonth(groupId.longValue(), Month.valueOf(month));
        return byGroupIdAndMonth.stream().map(this::mapToPayment).toList();
    }
    private PaymentDTO mapToPayment(Payment byStudentIdAndMonth) {
        return PaymentDTO.builder()
                .cost(byStudentIdAndMonth.getCost())
                .groupId(Math.toIntExact(byStudentIdAndMonth.getGroup().getId()))
                .studentName(byStudentIdAndMonth.getStudent().getUser().getFirstName())
                .month(byStudentIdAndMonth.getMonth())
                .build();
    }
}
