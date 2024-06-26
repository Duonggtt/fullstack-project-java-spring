package com.example.studenmanagewithnuxtjsandspring.repository;

import com.example.studenmanagewithnuxtjsandspring.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Integer> {
    List<Point> findAllByStudentId(Integer studentId);
}
