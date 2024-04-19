package com.company.lc_managment.controller;

import com.company.lc_managment.dto.ApiResult;
import com.company.lc_managment.dto.AttendanceDTO;
import com.company.lc_managment.dto.AttendanceGroupDTO;
import com.company.lc_managment.utils.AppConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AttendanceController.BASE_PATH)
public interface AttendanceController {

    String BASE_PATH = AppConstants.BASE_PATH;
    String GET_BY_STUDENT_ID_AND_MONTH = "/attendanceS/{id}/{month}";
    String GET_BY_GROUP_ID_AND_MONTH = "/attendanceG/{id}/{month}";

    @GetMapping(GET_BY_STUDENT_ID_AND_MONTH)
    ApiResult<AttendanceDTO> getAttendanceByStudentIdAndMonth(@PathVariable Integer id, @PathVariable String month);

    @GetMapping(GET_BY_GROUP_ID_AND_MONTH)
    ApiResult<AttendanceGroupDTO> getAttendanceByGroupIdAndMonth(@PathVariable Integer id, @PathVariable String month);
}
