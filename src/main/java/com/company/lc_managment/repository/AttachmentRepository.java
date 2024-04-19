package com.company.lc_managment.repository;

import com.company.lc_managment.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AttachmentRepository extends JpaRepository<Attachment,Long> {
}
