package com.company.lc_managment.service;


import com.company.lc_managment.dto.StudentDTO;
import com.company.lc_managment.entity.Student;
import com.company.lc_managment.repository.StudentRepository;
import com.company.lc_managment.service.auth.AuthServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final GroupServiceImpl groupService;
    private final AuthServiceImpl authService;
    private final StudentRepository studentRepository;

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = mapToStudent(studentDTO);
        studentRepository.save(student);
        return studentDTO;
    }

    private Student mapToStudent(StudentDTO studentDTO) {
        return Student.builder().group(groupService.mapToGroup(groupService.getById(studentDTO.getGroupId()))).user(authService.getUserByUsername(studentDTO.getUsername())).build();
    }

    @Override
    public List<StudentDTO> listStudent() {
        return studentRepository.findAll().stream().map(this::mapToStudentDTO).toList();
    }

    private StudentDTO mapToStudentDTO(Student student) {
        return StudentDTO.builder().username(student.getUser().getUsername()).groupId(Math.toIntExact(student.getGroup().getId())).build();

    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        return mapToStudentDTO(studentRepository.findById(id.longValue()).orElseThrow());
    }

    @Override
    public StudentDTO getStudentByGroupId(Integer groupId) {
        Student byGroupId = studentRepository.findByGroup_Id(Long.valueOf(groupId));
        return mapToStudentDTO(byGroupId);
    }

    @Override
    public boolean deleteStudent(Integer id) {
        studentRepository.deleteById(id.longValue());
        return true;
    }

    @Override
    public StudentDTO editStudent(Integer id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id.longValue()).orElseThrow();
        student.setGroup(groupService.mapToGroup(groupService.getById(studentDTO.getGroupId())));
        student.setUser(authService.getUserByUsername(student.getUser().getUsername()));
        return studentDTO;
    }
}
