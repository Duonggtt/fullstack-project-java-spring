package com.example.studenmanagewithnuxtjsandspring.controller;

import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertAdvisorRequest;
import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertLecturerRequest;
import com.example.studenmanagewithnuxtjsandspring.service.LecturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/api/v1/admin/lecturers")
public class LecturerController {

    private final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllLecturers(@RequestParam(required = false, defaultValue = "id") String sortField,
                                            @RequestParam(required = false, defaultValue = "esc") String sortDirection,
                                            @RequestParam(required = false, defaultValue = "1") Integer page,
                                            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(lecturerService.getAllLecturers(page, limit , sortField, sortDirection));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getLecturers() {
        return ResponseEntity.ok(lecturerService.getLecturers());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLecturer(@Valid @RequestBody UpsertLecturerRequest request) {
        return new ResponseEntity<>(lecturerService.createLecturer(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLecturer(@PathVariable Integer id,@Valid @RequestBody UpsertLecturerRequest request) {
        return new ResponseEntity<>(lecturerService.updateLecturer(id,request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAdvisorById(@PathVariable Integer id) {
        return ResponseEntity.ok(lecturerService.getLecturerById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteAdvisor(@PathVariable Integer id) {
        lecturerService.deleteLecturer(id);
    }
}
