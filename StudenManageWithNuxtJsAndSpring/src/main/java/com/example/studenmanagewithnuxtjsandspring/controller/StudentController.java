package com.example.studenmanagewithnuxtjsandspring.controller;

import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertClazzRequest;
import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertStudentRequest;
import com.example.studenmanagewithnuxtjsandspring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/api/v1/admin/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllStudents(@RequestParam(required = false, defaultValue = "id") String sortField,
                                            @RequestParam(required = false, defaultValue = "esc") String sortDirection,
                                            @RequestParam(required = false, defaultValue = "1") Integer page,
                                            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(studentService.getAllStudents(page, limit , sortField, sortDirection));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@Valid @RequestBody UpsertStudentRequest request) {
        return new ResponseEntity<>(studentService.createStudent(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id,@Valid @RequestBody UpsertStudentRequest request) {
        return new ResponseEntity<>(studentService.updateStudent(request,id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}
