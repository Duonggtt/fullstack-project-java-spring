package com.example.studenmanagewithnuxtjsandspring.controller;

import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertClazzRequest;
import com.example.studenmanagewithnuxtjsandspring.service.ClazzService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/api/v1/admin/clazzs")
public class ClazzController {
    private final ClazzService clazzService;

    public ClazzController(ClazzService clazzService) {
        this.clazzService = clazzService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllClazzs(@RequestParam(required = false, defaultValue = "id") String sortField,
                                          @RequestParam(required = false, defaultValue = "esc") String sortDirection,
                                          @RequestParam(required = false, defaultValue = "1") Integer page,
                                          @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(clazzService.getAllClazzs(page, limit , sortField, sortDirection));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createClazz(@Valid @RequestBody UpsertClazzRequest request) {
        return new ResponseEntity<>(clazzService.createClazz(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClazz(@PathVariable Integer id,@Valid @RequestBody UpsertClazzRequest request) {
        return new ResponseEntity<>(clazzService.updateClazz(id,request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClazzById(@PathVariable Integer id) {
        return ResponseEntity.ok(clazzService.getClazzById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteClazz(@PathVariable Integer id) {
        clazzService.deleteClazz(id);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> getClazzDtoById(@PathVariable Integer id) {
        return ResponseEntity.ok(clazzService.getClazzById(id));
    }
}
