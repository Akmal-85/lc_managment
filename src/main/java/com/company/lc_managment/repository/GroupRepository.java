package com.company.lc_managment.repository;

import com.company.lc_managment.entity.Group;
import com.company.lc_managment.enums.DaysOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    Group findByCourse_Id(Long course_id);
    Group findByDaysOfWeek(DaysOfWeek daysOfWeek);
    Group findByTeacherId(Long id);
}
