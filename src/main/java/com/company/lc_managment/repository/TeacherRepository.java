package com.company.lc_managment.repository;

import com.company.lc_managment.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
