package com.company.lc_managment.controller;

import com.company.lc_managment.dto.ApiResult;
import com.company.lc_managment.dto.CourseDTO;
import com.company.lc_managment.entity.Course;
import com.company.lc_managment.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CourseController.BASE_PATH)
public interface CourseController {
    String BASE_PATH = AppConstants.BASE_PATH;
    String ADD_PATH = "/course_add";
    String COURSE_LIST_PATH = "/courses";
    String GET_BY_ID_PATH= "/course/{id}";
    String GET_BY_GROUP_ID_PATH= "/course/{groupId}";
    String EDIT_BY_ID_PATH = "/course/{id}";
    String DELETE_BY_ID_PATH="/course/{id}";

    @PostMapping(ADD_PATH)
    ApiResult<CourseDTO> addCourse(@Valid @RequestBody CourseDTO courseDTO);

    @GetMapping(COURSE_LIST_PATH)
    ApiResult<List<CourseDTO>> listCourse();

    @GetMapping(GET_BY_ID_PATH)
    ApiResult<Course> getCourseById(@PathVariable Integer id);

    @GetMapping(GET_BY_GROUP_ID_PATH)
    ApiResult<CourseDTO> getCourseByGroupId(@PathVariable Integer groupId);

    @PutMapping(EDIT_BY_ID_PATH)
    ApiResult<CourseDTO> editCourseById(@PathVariable Integer id, @RequestBody CourseDTO courseDTO);

    @DeleteMapping(DELETE_BY_ID_PATH)
    ApiResult<?> deleteById(@PathVariable Integer id);




}
