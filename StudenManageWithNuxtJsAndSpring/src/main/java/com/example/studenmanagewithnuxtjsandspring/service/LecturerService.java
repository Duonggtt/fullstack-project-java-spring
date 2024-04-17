package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.Gender;
import com.example.studenmanagewithnuxtjsandspring.entity.Lecturer;
import com.example.studenmanagewithnuxtjsandspring.entity.Subject;
import com.example.studenmanagewithnuxtjsandspring.exception.NotFoundException;
import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertLecturerRequest;
import com.example.studenmanagewithnuxtjsandspring.repository.GenderRepository;
import com.example.studenmanagewithnuxtjsandspring.repository.LecturerRepository;
import com.example.studenmanagewithnuxtjsandspring.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private GenderRepository genderRepository;


    public Page<Lecturer> getAllLecturers(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return lecturerRepository.findAll(pageRequest);
    }

    public Page<Lecturer> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<Lecturer> lecturerPage;
        if(keyword != null) {
            lecturerPage = lecturerRepository.findAll(keyword,pageable);
        }else {
            lecturerPage = lecturerRepository.findAll(pageable);
        }

        List<Lecturer> lecturerList = lecturerPage.getContent();

        return new PageImpl<>(lecturerList, pageable, lecturerPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public Lecturer createLecturer(UpsertLecturerRequest request) {
        Gender gender = genderRepository.findById(request.getGenderId())
                .orElseThrow(() -> new NotFoundException("Gender not found with id = " + request.getGenderId()));

        List<Subject> subjects = subjectRepository.findAllById(request.getSubjectIds());

        Lecturer lecturer = new Lecturer();
        lecturer.setFullName(request.getFullName());
        lecturer.setEmail(request.getEmail());
        lecturer.setPhone(request.getPhone());
        lecturer.setGender(gender);
        lecturer.setSubjects(subjects);
        lecturerRepository.save(lecturer);
        return lecturer;
    }

    public Lecturer updateLecturer(Integer id ,UpsertLecturerRequest request) {
        Gender gender = genderRepository.findById(request.getGenderId())
                .orElseThrow(() -> new NotFoundException("Gender not found with id = " + request.getGenderId()));

        List<Subject> subjects = subjectRepository.findAllById(request.getSubjectIds());

        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lecturer not found with id = " + id));

        lecturer.setFullName(request.getFullName());
        lecturer.setEmail(request.getEmail());
        lecturer.setPhone(request.getPhone());
        lecturer.setGender(gender);
        lecturer.setSubjects(subjects);
        return lecturer;
    }

    public void deleteLecturer(Integer id) {
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lecturer not found with id = " + id));
        lecturerRepository.delete(lecturer);
    }


    public Lecturer getLecturerById(Integer id) {
        return lecturerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lecturer not found with id = " + id));
    }

    public List<Lecturer> getLecturers() {
        return lecturerRepository.findAll();
    }

}
