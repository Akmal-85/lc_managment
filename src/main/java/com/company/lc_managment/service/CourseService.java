package com.company.lc_managment.service;

import com.company.lc_managment.dto.CourseDTO;
import com.company.lc_managment.entity.Course;
import com.company.lc_managment.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    CourseDTO addCourse(CourseDTO courseDTO);

    List<CourseDTO> getListCourse();

    Course getCourseById(Integer id);

    CourseDTO getCourseByGroupId(Integer groupId);

    void deleteById(Integer id);

    CourseDTO editCourse(Integer id, CourseDTO courseDTO);

}
