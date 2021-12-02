package com.enercom.enercom.services.employee;

import com.enercom.enercom.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> findById(int id);

    int save(SaveEmployeeRequest request);

    void delete(int id);
}
