package com.enercom.enercom.repositories;

import com.enercom.enercom.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
