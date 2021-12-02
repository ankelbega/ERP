package com.enercom.enercom.repositories;

import com.enercom.enercom.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository  extends JpaRepository<Supplier, Integer> {
}
