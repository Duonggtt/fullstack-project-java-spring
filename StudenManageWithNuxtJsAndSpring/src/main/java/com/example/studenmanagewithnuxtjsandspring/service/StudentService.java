package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.*;
import com.example.studenmanagewithnuxtjsandspring.exception.NotFoundException;
import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertStudentRequest;
import com.example.studenmanagewithnuxtjsandspring.repository.*;
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

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private GenderRepository genderRepository;

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

        Gender gender = genderRepository.findById(request.getGenderId())
                .orElseThrow(() -> new NotFoundException("Gender not found with id = " + request.getGenderId()));

        Major major = majorRepository.findById(request.getMajorId())
                .orElseThrow(() -> new NotFoundException("Major not found with id = " + request.getMajorId()));

        Clazz clazz = clazzRepository.findById(request.getClazzId())
                .orElseThrow(() -> new NotFoundException("Clazz not found with id = " + request.getClazzId()));

        Student student = new Student();
        student.setFullName(request.getFullName());
        student.setBirthDate(request.getBirthDate());
        student.setAddress(request.getAddress());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setCmnd(request.getCmnd());
        student.setEthnicity(request.getEthnicity());
        student.setStatus("Đang học");
        student.setGender(gender);
        student.setMajor(major);
        student.setClazz(clazz);
        studentRepository.save(student);

        return student;
    }

        public Student updateStudent(UpsertStudentRequest request, Integer id) {
            Student student = studentRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Student not found with id = " + id));

            Gender gender = genderRepository.findById(request.getGenderId())
                    .orElseThrow(() -> new NotFoundException("Gender not found with id = " + request.getGenderId()));

            Major major = majorRepository.findById(request.getMajorId())
                    .orElseThrow(() -> new NotFoundException("Major not found with id = " + request.getMajorId()));

            Clazz clazz = clazzRepository.findById(request.getClazzId())
                    .orElseThrow(() -> new NotFoundException("Clazz not found with id = " + request.getClazzId()));

            student.setFullName(request.getFullName());
            student.setBirthDate(request.getBirthDate());
            student.setAddress(request.getAddress());
            student.setEmail(request.getEmail());
            student.setPhone(request.getPhone());
            student.setCmnd(request.getCmnd());
            student.setEthnicity(request.getEthnicity());
            student.setStatus(request.getStatus());
            student.setGender(gender);
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
