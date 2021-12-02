package com.enercom.enercom.controllers;

import com.enercom.enercom.domain.Attendance;
import com.enercom.enercom.services.attendance.AttendanceService;
import com.enercom.enercom.services.attendance.SaveAttendanceRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private AttendanceService attendanceService;

    public AttendanceController(final AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> get(@PathVariable int id) {
        var item = this.attendanceService.findById(id);

        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Attendance> getAll() {
        return attendanceService.findAll();
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveAttendanceRequest request) {
        return attendanceService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        attendanceService.delete(id);
    }
}
