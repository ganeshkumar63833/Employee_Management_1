package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.model.Performance;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long>{

}
