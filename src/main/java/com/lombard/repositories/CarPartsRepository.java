package com.lombard.repositories;


import com.lombard.entities.CarParts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartsRepository extends JpaRepository<CarParts, Long> {

}
