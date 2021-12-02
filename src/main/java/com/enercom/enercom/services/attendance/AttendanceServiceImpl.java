package com.enercom.enercom.services.attendance;

import com.enercom.enercom.domain.Attendance;
import com.enercom.enercom.repositories.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    private AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Optional<Attendance> findById(int id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        var item = attendanceRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        attendanceRepository.delete(item);
    }

    @Override
    public List<Attendance> findAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public int save(SaveAttendanceRequest request) {
        var dbItem = attendanceRepository.findById(request.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setTimeIn(request.getTimeIn());
            dbItem.get().setTimeOut(request.getTimeOut());
            dbItem.get().setRemarks(request.getRemarks());
            attendanceRepository.save(dbItem.get());
            return dbItem.get().getId();
        }

        var newItem = Attendance.builder()
                .timeIn(request.getTimeIn())
                .timeOut(request.getTimeOut())
                .remarks(request.getRemarks())
                .build();
        attendanceRepository.save(newItem);
        return newItem.getId();
    }
}
