package com.company.lc_managment.controller;

import com.company.lc_managment.dto.ApiResult;
import com.company.lc_managment.dto.StudentDTO;
import com.company.lc_managment.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(StudentController.BASE_PATH)
public interface StudentController {
    String BASE_PATH = AppConstants.BASE_PATH;
    String ADD_STUDENT = "/addStudent";
    String GET_STUDENT = "/students";
    String DELETE_STUDENT = "/student/{id}";
    String GET_STUDENT_BY_ID = "/student/{id}";
    String GET_STUDENT_BY_GROUP_ID = "/studentGroup/{id}";
    String EDIT_STUDENT = "/student/{id}";

    @PostMapping(ADD_STUDENT)
    ApiResult<StudentDTO> addStudent(@Valid @RequestBody StudentDTO studentDTO);

    @GetMapping(GET_STUDENT)
    ApiResult<List<StudentDTO>> getAllStudent();

    @GetMapping(GET_STUDENT_BY_ID)
    ApiResult<StudentDTO> getStudentById(@PathVariable Integer id);

    @GetMapping(GET_STUDENT_BY_GROUP_ID)
    ApiResult<StudentDTO> getStudentByGroupId(@PathVariable Integer id);

    @DeleteMapping(DELETE_STUDENT)
    ApiResult<?> deleteStudentById(@PathVariable Integer id);

    @PostMapping(EDIT_STUDENT)
    ApiResult<StudentDTO> editStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDTO);


}
