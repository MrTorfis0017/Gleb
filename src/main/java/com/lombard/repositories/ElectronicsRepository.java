package com.lombard.repositories;

import com.lombard.entities.Electronics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectronicsRepository extends JpaRepository<Electronics, Long> {
}
