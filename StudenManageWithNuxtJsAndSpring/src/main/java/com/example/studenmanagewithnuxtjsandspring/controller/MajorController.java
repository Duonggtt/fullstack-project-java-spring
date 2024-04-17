package com.example.studenmanagewithnuxtjsandspring.controller;

import com.example.studenmanagewithnuxtjsandspring.entity.Major;
import com.example.studenmanagewithnuxtjsandspring.service.MajorService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/api/v1/admin/majors")
public class MajorController {

    private final MajorService majorService;

    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllMajors(@RequestParam(required = false, defaultValue = "id") String sortField,
                                          @RequestParam(required = false, defaultValue = "esc") String sortDirection,
                                          @RequestParam(required = false, defaultValue = "1") Integer page,
                                          @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(majorService.getAllMajors(page, limit , sortField, sortDirection));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getMajors() {
        return ResponseEntity.ok(majorService.getMajors());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMajor(@Valid @RequestBody Major request) {
        return new ResponseEntity<>(majorService.createMajor(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMajor(@PathVariable Integer id,@Valid @RequestBody Major request) {
        return new ResponseEntity<>(majorService.updateMajor(request,id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMajorById(@PathVariable Integer id) {
        return ResponseEntity.ok(majorService.getMajorById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteMajors(@PathVariable Integer id) {
        majorService.deleteMajor(id);
    }
}
