package com.enercom.enercom.repositories;

import com.enercom.enercom.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
