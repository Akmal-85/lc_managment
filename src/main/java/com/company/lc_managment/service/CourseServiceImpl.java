package com.company.lc_managment.service;

import com.company.lc_managment.dto.CourseDTO;
import com.company.lc_managment.entity.Course;
import com.company.lc_managment.repository.CourseRepository;
import com.company.lc_managment.dto.CourseDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Override
    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course course = mapToCourse(courseDTO);
        Course saveCourse = courseRepository.save(course);
        return mapToCourseDTO(saveCourse);
    }


    @Override
    public List<CourseDTO> getListCourse() {
        List<Course> all = courseRepository.findAll();
        return all.stream().map(this::mapToCourseDTO).toList();
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.findCourseById(id.longValue());
    }

    @Override
    public CourseDTO getCourseByGroupId(Integer groupId) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        courseRepository.deleteById(id.longValue());
    }

    @Override
    public CourseDTO editCourse(Integer id, CourseDTO courseDTO) {

        Course courseById = courseRepository.findCourseById(id.longValue());
        courseById.setDesc(courseDTO.getDesc());
        courseById.setName(courseDTO.getName());
        courseById.setSale(courseDTO.getSale());
        courseById.setPrice(courseDTO.getPrice());
        courseRepository.save(courseById);
        return courseDTO;
    }
    private CourseDTO mapToCourseDTO(Course saveCourse) {

        return  CourseDTO.builder()
                .desc(saveCourse.getDesc())
                .sale(saveCourse.getSale())
                .price(saveCourse.getPrice())
                .name(saveCourse.getName())
                .build();
    }

    private Course mapToCourse(CourseDTO courseDTO) {
        return Course.builder()
                .name(courseDTO.getName())
                .price(courseDTO.getPrice())
                .desc(courseDTO.getDesc())
                .sale(courseDTO.getSale())
                .build();
    }

}
