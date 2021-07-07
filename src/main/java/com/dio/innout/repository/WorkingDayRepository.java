package com.dio.innout.repository;

import com.dio.innout.model.WorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingDayRepository extends JpaRepository<WorkingDay,Long> {
}
