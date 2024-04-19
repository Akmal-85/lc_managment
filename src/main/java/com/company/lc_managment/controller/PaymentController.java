package com.company.lc_managment.controller;


import com.company.lc_managment.dto.ApiResult;
import com.company.lc_managment.dto.PaymentDTO;
import com.company.lc_managment.utils.AppConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PaymentController.BASE_PATH)
public interface PaymentController {
    String BASE_PATH = AppConstants.BASE_PATH;

    String GET_STUDENT_ID_AND_MONTH ="/paymentS/{id}/{month}";
    String GET_GROUP_ID_AND_MONTH ="/paymentG/{id}/{month}";

    @GetMapping(GET_STUDENT_ID_AND_MONTH)
    ApiResult<PaymentDTO> getPaymentByStudentIdAndMonth(@PathVariable Integer id,@PathVariable String month);

    @GetMapping(GET_GROUP_ID_AND_MONTH)
    ApiResult<List<PaymentDTO>> getPaymentByGroupIdAndMonth(@PathVariable Integer id,@PathVariable String month);

}
