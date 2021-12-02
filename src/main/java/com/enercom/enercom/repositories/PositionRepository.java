package com.enercom.enercom.repositories;

import com.enercom.enercom.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
