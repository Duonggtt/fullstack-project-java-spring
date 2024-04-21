package com.example.studenmanagewithnuxtjsandspring.repository;

import com.example.studenmanagewithnuxtjsandspring.entity.GradeScale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GradeScaleRepository extends JpaRepository<GradeScale, Integer>{
    Optional<GradeScale> findByGrade(String grade);

    @Query("SELECT g FROM GradeScale g WHERE :gpa BETWEEN g.minGpa AND g.maxGpa")
    Optional<GradeScale> findGradeScaleByGpaRange(float gpa);
}
