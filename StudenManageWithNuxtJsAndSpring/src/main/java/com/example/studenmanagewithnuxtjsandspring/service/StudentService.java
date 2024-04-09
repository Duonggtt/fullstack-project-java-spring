package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.Clazz;
import com.example.studenmanagewithnuxtjsandspring.entity.Major;
import com.example.studenmanagewithnuxtjsandspring.entity.Student;
import com.example.studenmanagewithnuxtjsandspring.exception.NotFoundException;
import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertStudentRequest;
import com.example.studenmanagewithnuxtjsandspring.repository.ClazzRepository;
import com.example.studenmanagewithnuxtjsandspring.repository.MajorRepository;
import com.example.studenmanagewithnuxtjsandspring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClazzRepository clazzRepository;

    @Autowired
    private MajorRepository majorRepository;

    public Page<Student> getAllStudents(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return studentRepository.findAll(pageRequest);
    }

    public Page<Student> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<Student> studentPage;
        if(keyword != null) {
            studentPage = studentRepository.findAll(keyword,pageable);
        }else {
            studentPage = studentRepository.findAll(pageable);
        }

        List<Student> studentList = studentPage.getContent();

        return new PageImpl<>(studentList, pageable, studentPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public Student createStudent(UpsertStudentRequest request) {
        Student student = new Student();
        student.setFullName(request.getFullName());
        student.setBirthDate(request.getBirthDate());
        student.setAddress(request.getAddress());
        student.setAdmissionDate(request.getAdmissionDate());
        student.setGraduationDate(request.getGraduationDate());
        student.setGender(request.getGender());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setEthnicity(request.getEthnicity());
        student.setGpa(4);
        student.setStatus("Đang học");
        if (request.getMajorId() != null) {
            Major major = majorRepository.findById(request.getMajorId())
                    .orElseThrow(() -> new NotFoundException("Major not found with id = " + request.getMajorId()));
            student.setMajor(major);
        }

        if (request.getClazzId() != null) {
            Clazz clazz = clazzRepository.findById(request.getClazzId())
                    .orElseThrow(() -> new NotFoundException("Clazz not found with id = " + request.getClazzId()));
            student.setClazz(clazz);
        }
        studentRepository.save(student);

        return student;
    }

        public Student updateStudent(UpsertStudentRequest request, Integer id) {
            Student student = studentRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Student not found with id = " + id));
            Clazz clazz = clazzRepository.findById(request.getClazzId())
                    .orElseThrow(() -> new NotFoundException("Clazz not found with id = " + request.getClazzId()));
            Major major = majorRepository.findById(request.getMajorId())
                    .orElseThrow(() -> new NotFoundException("Major not found with id = " + request.getMajorId()));

            student.setFullName(request.getFullName());
            student.setBirthDate(request.getBirthDate());
            student.setAddress(request.getAddress());
            student.setAdmissionDate(request.getAdmissionDate());
            student.setGraduationDate(request.getGraduationDate());
            student.setGender(request.getGender());
            student.setEmail(request.getEmail());
            student.setPhone(request.getPhone());
            student.setEthnicity(request.getEthnicity());
            student.setGpa(request.getGpa());
            student.setStatus(request.getStatus());
            student.setMajor(major);
            student.setClazz(clazz);
            studentRepository.save(student);

            return student;
        }

    public void deleteStudent(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found with id = " + id));
        studentRepository.delete(student);
    }


    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found with id = " + id));
    }
}
