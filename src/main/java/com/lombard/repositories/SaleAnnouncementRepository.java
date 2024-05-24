package com.lombard.repositories;

import com.lombard.entities.SaleAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleAnnouncementRepository extends JpaRepository<SaleAnnouncement,Long> {
}
