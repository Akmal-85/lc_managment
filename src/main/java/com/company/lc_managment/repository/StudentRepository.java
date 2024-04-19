package com.company.lc_managment.repository;

import com.company.lc_managment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByGroup_Id(Long group_id);
}
