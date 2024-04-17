package com.example.studenmanagewithnuxtjsandspring.controller;

import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertAdvisorRequest;
import com.example.studenmanagewithnuxtjsandspring.service.AdvisorService;
import com.example.studenmanagewithnuxtjsandspring.service.MajorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/api/v1/admin/advisors")
public class AdvisorController {
    private final AdvisorService advisorService;

    public AdvisorController(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllAdvisors(@RequestParam(required = false, defaultValue = "id") String sortField,
                                          @RequestParam(required = false, defaultValue = "esc") String sortDirection,
                                          @RequestParam(required = false, defaultValue = "1") Integer page,
                                          @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(advisorService.getAllAdvisors(page, limit , sortField, sortDirection));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAdvisors() {
        return ResponseEntity.ok(advisorService.getAdvisors());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAdvisor(@Valid @RequestBody UpsertAdvisorRequest request) {
        return new ResponseEntity<>(advisorService.createAdvisor(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdvisor(@PathVariable Integer id,@Valid @RequestBody UpsertAdvisorRequest request) {
        return new ResponseEntity<>(advisorService.updateAdvisor(id,request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAdvisorById(@PathVariable Integer id) {
        return ResponseEntity.ok(advisorService.getAdvisorById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteAdvisor(@PathVariable Integer id) {
        advisorService.deleteAdvisor(id);
    }
}
