package com.enercom.enercom.repositories;

import com.enercom.enercom.domain.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
}
