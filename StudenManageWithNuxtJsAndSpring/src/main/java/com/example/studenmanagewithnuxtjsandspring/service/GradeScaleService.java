package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.Gender;
import com.example.studenmanagewithnuxtjsandspring.entity.GradeScale;
import com.example.studenmanagewithnuxtjsandspring.exception.NotFoundException;
import com.example.studenmanagewithnuxtjsandspring.repository.GenderRepository;
import com.example.studenmanagewithnuxtjsandspring.repository.GradeScaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeScaleService {
    @Autowired
    private GradeScaleRepository gradeScaleRepository;

    public GradeScale createGrade(GradeScale request) {
        GradeScale gradeScale = new GradeScale();
        gradeScale.setGrade(request.getGrade());
        gradeScale.setMinGpa(request.getMinGpa());
        gradeScale.setMaxGpa(request.getMaxGpa());
        gradeScaleRepository.save(gradeScale);
        return gradeScale;
    }

    public GradeScale updateGrade(Integer id , GradeScale request) {
        GradeScale gradeScale = gradeScaleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Grade not found with id = " + id));

        gradeScale.setGrade(request.getGrade());
        gradeScale.setMinGpa(request.getMinGpa());
        gradeScale.setMaxGpa(request.getMaxGpa());
        gradeScaleRepository.save(gradeScale);
        return gradeScale;
    }

    public GradeScale getGradeById(Integer id) {
        return gradeScaleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("GradeScale not found with id = " + id));
    }

    public GradeScale getGradeByGrade(String grade) {
        return gradeScaleRepository.findByGrade(grade)
                .orElseThrow(() -> new NotFoundException("GradeScale not found with grade = " + grade));
    }

    public List<GradeScale> getGrades() {
        return gradeScaleRepository.findAll();
    }
}
