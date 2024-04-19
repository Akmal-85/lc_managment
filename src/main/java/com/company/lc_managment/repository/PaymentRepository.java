package com.company.lc_managment.repository;

import com.company.lc_managment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Payment findByStudentIdAndMonth(Long student_id, Month month);
    List<Payment> findByGroup_IdAndMonth(Long group_id, Month month);
}
