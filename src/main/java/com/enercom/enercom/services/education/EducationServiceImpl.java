package com.enercom.enercom.services.education;

import com.enercom.enercom.domain.Education;
import com.enercom.enercom.repositories.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationService{
    private EducationRepository educationRepository;

    public EducationServiceImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public Optional<Education> findById(int id) {
        return educationRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        var item = educationRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        educationRepository.delete(item);
    }

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    public int save(SaveEducationRequest request) {
        var dbItem = educationRepository.findById(request.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setDegree(request.getDegree());
            dbItem.get().setStartDate(request.getStartDate());
            dbItem.get().setEndDate(request.getEndDate());
            dbItem.get().setSkills(request.getSkills());
            dbItem.get().setTrainings(request.getTrainings());
            educationRepository.save(dbItem.get());
            return dbItem.get().getId();
        }

        var newItem = Education.builder()
                .degree(request.getDegree())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .skills(request.getSkills())
                .trainings(request.getTrainings())
                .build();
        educationRepository.save(newItem);
        return newItem.getId();
    }
}
