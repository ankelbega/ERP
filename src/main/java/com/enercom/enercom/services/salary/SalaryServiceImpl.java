package com.enercom.enercom.services.salary;

import com.enercom.enercom.domain.Salary;
import com.enercom.enercom.repositories.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryServiceImpl implements SalaryService {
    private SalaryRepository salaryRepository;

    public SalaryServiceImpl(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public Optional<Salary> findById(int id) {
        return salaryRepository.findById(id);
    }

    @Override
    public void delete(int empId) {
        var item = salaryRepository
                .findById(empId).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        salaryRepository.delete(item);
    }

    @Override
    public List<Salary> findAll() {
        return salaryRepository.findAll();
    }

    @Override
    public int save(SaveSalaryRequest request) {
        var dbItem = salaryRepository.findById(request.getEmpId());
        if (dbItem.isPresent()) {
            dbItem.get().setSalaryRange(request.getSalaryRange());
            dbItem.get().setAnnualIncome(request.getAnnualIncome());
            dbItem.get().setInsurance(request.getInsurance());
            dbItem.get().setLoans(request.getLoans());
            salaryRepository.save(dbItem.get());
            return dbItem.get().getEmpId();
        }

        var newItem = Salary.builder()
                .salaryRange(request.getSalaryRange())
                .annualIncome(request.getAnnualIncome())
                .insurance(request.getInsurance())
                .loans(request.getLoans())
                .build();
        salaryRepository.save(newItem);
        return newItem.getEmpId();
    }
}
