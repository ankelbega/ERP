package com.enercom.enercom.services.attendance;

import com.enercom.enercom.domain.Attendance;

import java.util.List;
import java.util.Optional;

public interface AttendanceService {
    List<Attendance> findAll();

    Optional<Attendance> findById(int id);

    int save(SaveAttendanceRequest request);

    void delete(int id);
}

