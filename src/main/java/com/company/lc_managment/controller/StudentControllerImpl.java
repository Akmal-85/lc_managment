package com.company.lc_managment.controller;

import com.company.lc_managment.dto.ApiResult;
import com.company.lc_managment.dto.StudentDTO;
import com.company.lc_managment.service.StudentService;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController {
    private  final StudentService studentService;
    @Override
    public ApiResult<StudentDTO> addStudent(StudentDTO studentDTO) {
        return ApiResult.successResponse(studentService.addStudent(studentDTO));
    }

    @Override
    public ApiResult<List<StudentDTO>> getAllStudent() {
        return ApiResult.successResponse(studentService.listStudent());
    }

    @Override
    public ApiResult<StudentDTO> getStudentById(Integer id) {
        return ApiResult.successResponse(studentService.getStudentById(id));
    }

    @Override
    public ApiResult<StudentDTO> getStudentByGroupId(Integer id) {
        return ApiResult.successResponse(studentService.getStudentByGroupId(id));
    }

    @Override
    public ApiResult<?> deleteStudentById(Integer id) {
        boolean isDelete =studentService.deleteStudent(id);
        return isDelete ? ApiResult.successResponse("delete"):ApiResult.errorResponse(400,"no way") ;
    }

    @Override
    public ApiResult<StudentDTO> editStudent(Integer id, StudentDTO studentDTO) {
        return ApiResult.successResponse(studentService.editStudent(id,studentDTO));
    }
}
