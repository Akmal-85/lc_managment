package com.company.lc_managment.controller;

import com.company.lc_managment.dto.ApiResult;
import com.company.lc_managment.dto.CourseDTO;
import com.company.lc_managment.entity.Course;
import com.company.lc_managment.service.CourseService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CourseControllerImpl implements CourseController {
    private final CourseService courseService;

    @Override
    public ApiResult<CourseDTO> addCourse(CourseDTO courseDTO) {
        CourseDTO course = courseService.addCourse(courseDTO);
        return ApiResult.successResponse(course);
    }

    @Override
    public ApiResult<List<CourseDTO>> listCourse() {
        List<CourseDTO> list = courseService.getListCourse();
        return ApiResult.successResponse(list);
    }

    @Override
    public ApiResult<Course> getCourseById(Integer id) {
        return ApiResult.successResponse(courseService.getCourseById(id));
    }

    @Override
    public ApiResult<CourseDTO> getCourseByGroupId(Integer groupId) {
        return ApiResult.successResponse(courseService.getCourseByGroupId(groupId));
    }

    @Override
    public ApiResult<CourseDTO> editCourseById(Integer id, CourseDTO courseDTO) {
        CourseDTO course = courseService.editCourse(id,courseDTO);
        return ApiResult.successResponse(course);
    }

    @Override
    public ApiResult<?> deleteById(Integer id) {
        courseService.deleteById(id);
        return ApiResult.successResponse("okay") ;
    }
}
