package com.example.studenmanagewithnuxtjsandspring.controller;

import com.example.studenmanagewithnuxtjsandspring.entity.Gender;
import com.example.studenmanagewithnuxtjsandspring.entity.Major;
import com.example.studenmanagewithnuxtjsandspring.service.GenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/api/v1/admin/genders")
public class GenderController {

    private final GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllGenders() {
        return ResponseEntity.ok(genderService.getGenders());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGender(@PathVariable Integer id, @Valid @RequestBody Gender request) {
        return new ResponseEntity<>(genderService.updateGender(id,request), HttpStatus.CREATED);
    }
}
