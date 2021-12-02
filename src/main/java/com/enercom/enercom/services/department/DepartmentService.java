package com.enercom.enercom.services.department;

import com.enercom.enercom.domain.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> findAll();

    Optional<Department> findById(int id);

    int save(SaveDepartmentRequest request);

    void delete(int id);
}
