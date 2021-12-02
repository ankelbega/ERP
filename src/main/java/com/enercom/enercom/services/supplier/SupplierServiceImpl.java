package com.enercom.enercom.services.supplier;

import com.enercom.enercom.domain.Supplier;
import com.enercom.enercom.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService{
    private SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Optional<Supplier> findById(int id) {
        return supplierRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        var item = supplierRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        supplierRepository.delete(item);
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public int save(SaveSupplierRequest request) {
        var dbItem = supplierRepository.findById(request.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setEntityName(request.getEntityName());
            dbItem.get().setAddress(request.getAddress());
            dbItem.get().setNipt(request.getNipt());
            dbItem.get().setCity(request.getCity());
            dbItem.get().setZipCode(request.getZipCode());
            dbItem.get().setFirstName(request.getFirstName());
            dbItem.get().setLastName(request.getLastName());
            dbItem.get().setMobile(request.getMobile());
            dbItem.get().setEmail(request.getEmail());
            supplierRepository.save(dbItem.get());
            return dbItem.get().getId();
        }

        var newItem = Supplier.builder()
                .entityName(request.getEntityName())
                .address(request.getAddress())
                .nipt(request.getNipt())
                .city(request.getCity())
                .zipCode(request.getZipCode())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .mobile(request.getMobile())
                .registeredAt(LocalDate.now())
                .updatedAt(LocalDateTime.now())
                .build();
        supplierRepository.save(newItem);
        return newItem.getId();
    }
}
