package com.dio.innout.repository;

import com.dio.innout.model.DateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTypeRepository extends JpaRepository<DateType,Long> {
}
