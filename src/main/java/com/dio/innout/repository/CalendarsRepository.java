package com.dio.innout.repository;

import com.dio.innout.model.Calendars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarsRepository extends JpaRepository<Calendars,Long> {
}
