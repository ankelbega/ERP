package com.enercom.enercom.services.employee;

import com.enercom.enercom.domain.Employee;
import com.enercom.enercom.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        var item = employeeRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        employeeRepository.delete(item);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public int save(SaveEmployeeRequest request) {
        var dbItem = employeeRepository.findById(request.getEmpId());
        if (dbItem.isPresent()) {
            dbItem.get().setFirstName(request.getFirstName());
            dbItem.get().setLastName(request.getLastName());
            dbItem.get().setBirthDate(request.getBirthDate());
            dbItem.get().setAge(request.getAge());
            dbItem.get().setGender(request.getGender());
            dbItem.get().setAddress(request.getAddress());
            dbItem.get().setEmployedDate(request.getEmployedDate());
            employeeRepository.save(dbItem.get());
            return dbItem.get().getEmpId();
        }

        var newItem = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthDate(request.getBirthDate())
                .age(request.getAge())
                .gender(request.getGender())
                .address(request.getAddress())
                .employedDate(request.getEmployedDate())
                .build();
        employeeRepository.save(newItem);
        return newItem.getEmpId();
    }
}
