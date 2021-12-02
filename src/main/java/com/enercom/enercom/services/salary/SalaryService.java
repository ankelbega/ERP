package com.enercom.enercom.services.salary;

import com.enercom.enercom.domain.Salary;

import java.util.List;
import java.util.Optional;

public interface SalaryService {
    List<Salary> findAll();

    Optional<Salary> findById(int id);

    int save(SaveSalaryRequest request);

    void delete(int id);
}
