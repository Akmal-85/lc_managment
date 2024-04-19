package com.company.lc_managment.controller;

import com.company.lc_managment.dto.ApiResult;
import com.company.lc_managment.dto.TeacherDTO;
import com.company.lc_managment.service.TeacherService;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class TeacherControllerImpl implements TeacherController {

    private final TeacherService teacherService;
    @Override
    public ApiResult<TeacherDTO> add(TeacherDTO teacherDTO) {
        return ApiResult.successResponse(teacherService.addTeacher(teacherDTO));
    }

    @Override
    public ApiResult<List<TeacherDTO>> getAllTeacher() {
        return ApiResult.successResponse(teacherService.getAllTeacher());
    }

    @Override
    public ApiResult<TeacherDTO> getTeacherById(Integer id) {
        return ApiResult.successResponse(teacherService.getTeacherById(id));
    }

    @Override
    public ApiResult<?> deleteTeacherById(Integer id) {
       boolean isDelete = teacherService.deleteTeacher(id);
        return isDelete ? ApiResult.successResponse("delete") : ApiResult.errorResponse(400, "no way");
    }

    @Override
    public ApiResult<TeacherDTO> editTeacher(Integer id, TeacherDTO teacherDTO) {
        return ApiResult.successResponse(teacherService.editTeacher(id,teacherDTO));
    }
}
