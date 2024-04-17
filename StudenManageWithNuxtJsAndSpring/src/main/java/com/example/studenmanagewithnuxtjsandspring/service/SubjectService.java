package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.Subject;
import com.example.studenmanagewithnuxtjsandspring.exception.NotFoundException;
import com.example.studenmanagewithnuxtjsandspring.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Page<Subject> getAllSubjects(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return subjectRepository.findAll(pageRequest);
    }

    public Page<Subject> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<Subject> subjectPage;
        if(keyword != null) {
            subjectPage = subjectRepository.findAll(keyword,pageable);
        }else {
            subjectPage = subjectRepository.findAll(pageable);
        }

        List<Subject> subjectList = subjectPage.getContent();

        return new PageImpl<>(subjectList, pageable, subjectPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public Subject createSubject(Subject request) {
        Subject subject = new Subject();
        subject.setName(request.getName());
        subject.setDescription(request.getDescription());
        subjectRepository.save(subject);
        return subject;
    }

    public Subject updateSubject(Subject request, Integer id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subject not found with id = " + id));

        subject.setName(request.getName());
        subject.setDescription(request.getDescription());
        subjectRepository.save(subject);
        return subject;
    }

    public void deleteSubject(Integer id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subject not found with id = " + id));
        subjectRepository.delete(subject);
    }

    public Subject getSubjectById(Integer id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subject not found with id = " + id));
    }

    public List<Subject> findSubjectsByIds(List<Integer> ids) {
        return subjectRepository.findAllById(ids);
    }
}
