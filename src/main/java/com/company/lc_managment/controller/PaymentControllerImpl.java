package com.company.lc_managment.controller;

import com.company.lc_managment.dto.ApiResult;
import com.company.lc_managment.dto.PaymentDTO;
import com.company.lc_managment.service.PaymentService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor

public class PaymentControllerImpl implements PaymentController {
    private final PaymentService paymentService;

    @Override
    public ApiResult<PaymentDTO> getPaymentByStudentIdAndMonth(Integer id, String month) {
        return ApiResult.successResponse(paymentService.getPaymentByStudentIdAndMonth(id,month));
    }

    @Override
    public ApiResult<List<PaymentDTO>> getPaymentByGroupIdAndMonth(Integer id, String month) {
        return ApiResult.successResponse(paymentService.getPaymentByGroupIdAndMonth(id,month));
    }
}
