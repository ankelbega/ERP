package com.enercom.enercom.services.supplier;

import com.enercom.enercom.domain.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<Supplier> findAll();

    Optional<Supplier> findById(int id);

    int save(SaveSupplierRequest request);

    void delete(int id);
}
