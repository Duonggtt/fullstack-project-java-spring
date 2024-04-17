package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.AcademicYear;
import com.example.studenmanagewithnuxtjsandspring.exception.NotFoundException;
import com.example.studenmanagewithnuxtjsandspring.repository.AcademicYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicYearService {

    @Autowired
    private AcademicYearRepository academicYearRepository;

    public AcademicYear createAcademicYear(AcademicYear request) {
        AcademicYear academicYear = new AcademicYear();
        academicYear.setYearName(request.getYearName());
        academicYearRepository.save(academicYear);
        return academicYear;
    }

    public AcademicYear updateAcademicYear(Integer id, AcademicYear request) {
        AcademicYear academicYear = academicYearRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("AcademicYear not found"));

        academicYear.setYearName(request.getYearName());
        academicYearRepository.save(academicYear);
        return academicYear;
    }

    public List<AcademicYear> getAllAcademicYears() {
        return academicYearRepository.findAll();
    }

    public AcademicYear getAcademicYearById(Integer id) {
        return academicYearRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("AcademicYear not found"));
    }

}
