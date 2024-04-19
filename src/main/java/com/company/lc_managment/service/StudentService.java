package com.company.lc_managment.service;

import com.company.lc_managment.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {


    StudentDTO addStudent(StudentDTO studentDTO);

    List<StudentDTO> listStudent();

    StudentDTO getStudentById(Integer id);

    StudentDTO getStudentByGroupId(Integer groupId);

    boolean deleteStudent(Integer id);

    StudentDTO editStudent(Integer id, StudentDTO studentDTO);

}
