package com.example.studenmanagewithnuxtjsandspring.controller;

import com.example.studenmanagewithnuxtjsandspring.entity.Subject;
import com.example.studenmanagewithnuxtjsandspring.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/api/v1/admin/subjects")
public class SubjectController {
    private final SubjectService subjectService;


    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllSubjects(@RequestParam(required = false, defaultValue = "id") String sortField,
                                            @RequestParam(required = false, defaultValue = "esc") String sortDirection,
                                            @RequestParam(required = false, defaultValue = "1") Integer page,
                                            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(subjectService.getAllSubjects(page, limit , sortField, sortDirection));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSubject(@Valid @RequestBody Subject request) {
        return new ResponseEntity<>(subjectService.createSubject(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable Integer id,@Valid @RequestBody Subject request) {
        return new ResponseEntity<>(subjectService.updateSubject(request,id), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getSubjectById(@PathVariable Integer id) {
        return ResponseEntity.ok(subjectService.getSubjectById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Integer id) {
        subjectService.deleteSubject(id);
    }
}
