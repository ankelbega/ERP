package com.enercom.enercom.services.position;

import com.enercom.enercom.domain.Position;
import com.enercom.enercom.repositories.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl  implements PositionService {
    private PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public Optional<Position> findById(int id) {
        return positionRepository.findById(id);
    }

    @Override
    public void delete(int positionId) {
        var item = positionRepository
                .findById(positionId).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        positionRepository.delete(item);
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public int save(SavePositionRequest request) {
        var dbItem = positionRepository.findById(request.getPositionId());
        if (dbItem.isPresent()) {
            dbItem.get().setPositionName(request.getPositionName());
            positionRepository.save(dbItem.get());
            return dbItem.get().getPositionId();
        }

        var newItem = Position.builder()
                .positionName(request.getPositionName())
                .build();
        positionRepository.save(newItem);
        return newItem.getPositionId();
    }
}
