package com.example.studenmanagewithnuxtjsandspring.controller;

import com.example.studenmanagewithnuxtjsandspring.entity.AcademicYear;
import com.example.studenmanagewithnuxtjsandspring.service.AcademicYearService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/api/v1/admin/academic-years")
public class AcademicYearController {

    private final AcademicYearService academicYearService;

    public AcademicYearController(AcademicYearService academicYearService) {
        this.academicYearService = academicYearService;
    }


    @GetMapping("/")
    public ResponseEntity<?> getAllAcademicYears() {
        return ResponseEntity.ok(academicYearService.getAllAcademicYears());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAcademicYear(@Valid @RequestBody AcademicYear request) {
        return new ResponseEntity<>(academicYearService.createAcademicYear(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAcademicYear(@PathVariable Integer id,@Valid @RequestBody AcademicYear request) {
        return new ResponseEntity<>(academicYearService.updateAcademicYear(id,request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAcademicYearById(@PathVariable Integer id) {
        return ResponseEntity.ok(academicYearService.getAcademicYearById(id));  
    }
}
