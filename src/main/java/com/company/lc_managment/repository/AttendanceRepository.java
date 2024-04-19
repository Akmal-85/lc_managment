package com.company.lc_managment.repository;

import com.company.lc_managment.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {

    Attendance findByStudentIdAndDate(Long student_id, LocalDate date);
    Attendance findByGroup_IdAndDate(Long group_id, LocalDate date);
}
