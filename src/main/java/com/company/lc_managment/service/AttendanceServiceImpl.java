package com.company.lc_managment.service;

import com.company.lc_managment.dto.AttendanceDTO;
import com.company.lc_managment.dto.AttendanceGroupDTO;
import com.company.lc_managment.entity.Attendance;
import com.company.lc_managment.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private  final AttendanceRepository attendanceRepository;
    @Override
    public AttendanceDTO getAttendanceByStudentIdAndMonth(Integer studentId, String month) {
        Attendance byStudentIdAndDate = attendanceRepository.findByStudentIdAndDate(studentId.longValue(), LocalDate.ofEpochDay(Date.parse(month)));
        return mapToAttendanceDTO(byStudentIdAndDate);
    }
    @Override
    public AttendanceGroupDTO getAttendanceByGroupIdAndMonth(Integer groupId, String month) {
        Attendance byGroupIdAndDate = attendanceRepository.findByGroup_IdAndDate(groupId.longValue(), LocalDate.ofEpochDay(Date.parse(month)));
        return mapToAttendanceGroupDTO(byGroupIdAndDate);
    }

    private AttendanceGroupDTO mapToAttendanceGroupDTO(Attendance byGroupIdAndDate) {
        List<String> list = byGroupIdAndDate.getGroup().getStudent().stream().map(student -> student.getUser().getUsername()).toList();


        return AttendanceGroupDTO.builder()
                .check(byGroupIdAndDate.isChecked())
                .date(byGroupIdAndDate.getDate())
                .studentNames(list)
                .groupId(Math.toIntExact(byGroupIdAndDate.getId()))
                .build();
    }

    private AttendanceDTO mapToAttendanceDTO(Attendance attendance) {
        return AttendanceDTO.builder()
                .check(attendance.isChecked())
                .studentName(attendance.getStudent().getUser().getUsername())
                .date(attendance.getDate())
                .groupName(attendance.getGroup().toString())
                .build();


    }
}
