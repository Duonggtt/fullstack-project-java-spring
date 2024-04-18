package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.Point;
import com.example.studenmanagewithnuxtjsandspring.entity.Student;
import com.example.studenmanagewithnuxtjsandspring.entity.Subject;
import com.example.studenmanagewithnuxtjsandspring.exception.NotFoundException;
import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertPointRequest;
import com.example.studenmanagewithnuxtjsandspring.repository.PointRepository;
import com.example.studenmanagewithnuxtjsandspring.repository.StudentRepository;
import com.example.studenmanagewithnuxtjsandspring.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Point createPoint(UpsertPointRequest request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new NotFoundException("Student not found with id = " + request.getStudentId()));

        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new NotFoundException("Subject not found with id = " + request.getSubjectId()));

        Point point = new Point();
        point.setDiligencePoint(request.getDiligencePoint());
        point.setMidTermPoint(request.getMidTermPoint());
        point.setFinalPoint(request.getFinalPoint());
        point.setStatus(request.getStatus());
        point.setGpa((request.getDiligencePoint() + request.getMidTermPoint() * 2 + request.getFinalPoint() * 7) / 9);
        point.setStudent(student);
        point.setSubject(subject);
        pointRepository.save(point);
        return point;
    }


    public Point updatePoint(UpsertPointRequest request, Integer id) {
        Point point = pointRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Point not found with id = " + id));
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new NotFoundException("Student not found with id = " + request.getStudentId()));

        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new NotFoundException("Subject not found with id = " + request.getSubjectId()));

        point.setDiligencePoint(request.getDiligencePoint());
        point.setMidTermPoint(request.getMidTermPoint());
        point.setFinalPoint(request.getFinalPoint());
        point.setStatus(request.getStatus());
        point.setGpa((request.getDiligencePoint() + request.getMidTermPoint() * 2 + request.getFinalPoint() * 7) / 9);
        point.setStudent(student);
        point.setSubject(subject);
        pointRepository.save(point);
        return point;
    }


    public void deletePoint(Integer id) {
        Point point = pointRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("point not found with id = " + id));
        pointRepository.delete(point);
    }


    public Point getPointById(Integer id) {
        return pointRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Point not found with id = " + id));
    }

    public List<Point> getPoints() {
        return pointRepository.findAll();
    }

    public List<Point> findPointsByStudentId(Integer studentId) {
        return pointRepository.findAllByStudentId(studentId);
    }
}
