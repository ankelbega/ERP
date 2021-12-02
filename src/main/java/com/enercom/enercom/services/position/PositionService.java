package com.enercom.enercom.services.position;

import com.enercom.enercom.domain.Position;

import java.util.List;
import java.util.Optional;

public interface PositionService {
    List<Position> findAll();

    Optional<Position> findById(int id);

    int save(SavePositionRequest request);

    void delete(int id);
}
