package com.company.lc_managment.controller;

import com.company.lc_managment.dto.ApiResult;
import com.company.lc_managment.dto.TeacherDTO;
import com.company.lc_managment.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(TeacherController.BASE_PATH)
public interface TeacherController {
    String BASE_PATH = AppConstants.BASE_PATH;
    String ADD_TEACHER = "/addTeacher";
    String GET_TEACHER = "/teacher";
    String DELETE_TEACHER = "/teacher/{id}";
    String GET_TEACHER_BY_ID = "/teacher/{id}";
    String EDIT_TEACHER="/teacher/{id}";

    @PostMapping(ADD_TEACHER)
    ApiResult<TeacherDTO> add(@Valid @RequestBody TeacherDTO teacherDTO);

    @GetMapping(GET_TEACHER)
    ApiResult<List<TeacherDTO>> getAllTeacher();

    @GetMapping(GET_TEACHER_BY_ID)
    ApiResult<TeacherDTO> getTeacherById(@PathVariable Integer id);

    @DeleteMapping(DELETE_TEACHER)
    ApiResult<?> deleteTeacherById(@PathVariable Integer id);

    @PostMapping(EDIT_TEACHER)
    ApiResult<TeacherDTO> editTeacher(@PathVariable Integer id,@RequestBody TeacherDTO teacherDTO);


}
