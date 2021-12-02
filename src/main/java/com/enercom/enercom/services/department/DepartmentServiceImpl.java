package com.enercom.enercom.services.department;

import com.enercom.enercom.domain.Department;
import com.enercom.enercom.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Optional<Department> findById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        var item = departmentRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        departmentRepository.delete(item);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public int save(SaveDepartmentRequest request) {
        var dbItem = departmentRepository.findById(request.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setDepartmentName(request.getDepartmentName());
            departmentRepository.save(dbItem.get());
            return dbItem.get().getId();
        }

        var newItem = Department.builder()
                .departmentName(request.getDepartmentName())
                .build();
        departmentRepository.save(newItem);
        return newItem.getId();
    }
}
