package com.example.studenmanagewithnuxtjsandspring.controller;

import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertPointRequest;
import com.example.studenmanagewithnuxtjsandspring.service.PointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/api/v1/admin/points")
public class PointController {

    private final PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }


    @GetMapping("/")
    public ResponseEntity<?> getPoints() {
        return ResponseEntity.ok(pointService.getPoints());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPoint(@Valid @RequestBody UpsertPointRequest request) {
        return new ResponseEntity<>(pointService.createPoint(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePoint(@PathVariable Integer id,@Valid @RequestBody UpsertPointRequest request) {
        return new ResponseEntity<>(pointService.updatePoint(request,id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPointById(@PathVariable Integer id) {
        return ResponseEntity.ok(pointService.getPointById(id));
    }

    @DeleteMapping("/{id}")
    public void deletePoint(@PathVariable Integer id) {
        pointService.deletePoint(id);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getPointsByStudentId(@PathVariable Integer studentId) {
        return ResponseEntity.ok(pointService.findPointsByStudentId(studentId));
    }
}
