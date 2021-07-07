package com.dio.innout.repository;

import com.dio.innout.model.HourBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HourBankRepository extends JpaRepository<HourBank,Long> {
}
