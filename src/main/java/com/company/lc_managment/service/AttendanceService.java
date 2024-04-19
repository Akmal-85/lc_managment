package com.company.lc_managment.service;

import com.company.lc_managment.dto.AttendanceDTO;
import com.company.lc_managment.dto.AttendanceGroupDTO;
import org.springframework.stereotype.Service;

@Service
public interface AttendanceService {
    AttendanceDTO getAttendanceByStudentIdAndMonth(Integer studentId, String month);

    AttendanceGroupDTO getAttendanceByGroupIdAndMonth(Integer groupId, String month);
}
