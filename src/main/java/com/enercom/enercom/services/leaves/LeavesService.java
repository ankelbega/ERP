package com.enercom.enercom.services.leaves;

import com.enercom.enercom.domain.Leaves;

import java.util.List;
import java.util.Optional;

public interface LeavesService  {
    List<Leaves> findAll();

    Optional<Leaves> findById(int id);

    int save(SaveLeavesRequest request);

    void delete(int id);
}
