package com.company.lc_managment.controller;

import com.company.lc_managment.dto.ApiResult;
import com.company.lc_managment.dto.AttendanceDTO;
import com.company.lc_managment.dto.AttendanceGroupDTO;
import com.company.lc_managment.service.AttendanceService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AttendanceControllerImpl implements AttendanceController {
    private final AttendanceService attendanceService;
    @Override
    public ApiResult<AttendanceDTO> getAttendanceByStudentIdAndMonth(Integer id, String month) {
        return ApiResult.successResponse(attendanceService.getAttendanceByStudentIdAndMonth(id,month));
    }

    @Override
    public ApiResult<AttendanceGroupDTO> getAttendanceByGroupIdAndMonth(Integer id, String month) {

        return ApiResult.successResponse(attendanceService.getAttendanceByGroupIdAndMonth(id,month));
    }
}
