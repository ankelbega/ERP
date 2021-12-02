package com.enercom.enercom.services.education;

import com.enercom.enercom.domain.Education;

import java.util.List;
import java.util.Optional;

public interface EducationService {
    List<Education> findAll();

    Optional<Education> findById(int id);

    int save(SaveEducationRequest request);

    void delete(int id);
}
