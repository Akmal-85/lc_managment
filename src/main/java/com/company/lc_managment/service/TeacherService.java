package com.company.lc_managment.service;

import com.company.lc_managment.dto.TeacherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    TeacherDTO addTeacher(TeacherDTO teacherDTO);

    List<TeacherDTO> getAllTeacher();

    TeacherDTO getTeacherById(Integer id);

    boolean deleteTeacher(Integer id);

    TeacherDTO editTeacher(Integer id, TeacherDTO teacherDTO);
}
