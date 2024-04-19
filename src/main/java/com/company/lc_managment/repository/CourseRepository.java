package com.company.lc_managment.repository;

import com.company.lc_managment.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Course findCourseById(Long id);
}
