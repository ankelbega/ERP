package com.enercom.enercom.services.leaves;

import com.enercom.enercom.domain.Leaves;
import com.enercom.enercom.repositories.LeavesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeavesServiceImpl implements LeavesService {
    private LeavesRepository leavesRepository;

    public LeavesServiceImpl(LeavesRepository leavesRepository) {
        this.leavesRepository = leavesRepository;
    }

    @Override
    public Optional<Leaves> findById(int id) {
        return leavesRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        var item = leavesRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        leavesRepository.delete(item);
    }

    @Override
    public List<Leaves> findAll() {
        return leavesRepository.findAll();
    }

    @Override
    public int save(SaveLeavesRequest request) {
        var dbItem = leavesRepository.findById(request.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setStartDate(request.getEndDate());
            dbItem.get().setEndDate(request.getEndDate());
            dbItem.get().setTotalDays(request.getTotalDays());
            leavesRepository.save(dbItem.get());
            return dbItem.get().getId();
        }

        var newItem = Leaves.builder()
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .totalDays(request.getTotalDays())
                .build();
        leavesRepository.save(newItem);
        return newItem.getId();
    }
}
