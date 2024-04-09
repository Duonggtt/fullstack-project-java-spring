package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.Clazz;
import com.example.studenmanagewithnuxtjsandspring.exception.NotFoundException;
import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertClazzRequest;
import com.example.studenmanagewithnuxtjsandspring.repository.ClazzRepository;
import com.example.studenmanagewithnuxtjsandspring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzService {

    @Autowired
    private ClazzRepository clazzRepository;

    @Autowired
    private StudentRepository studentRepository;
    public Page<Clazz> getAllClazzs(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return clazzRepository.findAll(pageRequest);
    }

    public Page<Clazz> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<Clazz> clazzPage;
        if(keyword != null) {
            clazzPage = clazzRepository.findAll(keyword,pageable);
        }else {
            clazzPage = clazzRepository.findAll(pageable);
        }

        List<Clazz> clazzList = clazzPage.getContent();

        return new PageImpl<>(clazzList, pageable, clazzPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public Clazz createClazz(UpsertClazzRequest request) {
        Clazz clazz = new Clazz();

        clazz.setClassName(request.getClassName());
        clazz.setCourseNum(request.getCourseNum());
        clazz.setAdvisorName(request.getAdvisorName());
        clazz.setMonitorName(request.getMonitorName());
        clazzRepository.save(clazz);
        return clazz;
    }

    public Clazz updateClazz(Integer id, UpsertClazzRequest request) {
        Clazz clazz = clazzRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Clazz not found with id = " + id));

        clazz.setClassName(request.getClassName());
        clazz.setCourseNum(request.getCourseNum());
        clazz.setAdvisorName(request.getAdvisorName());
        clazz.setMonitorName(request.getMonitorName());
        clazzRepository.save(clazz);
        return clazz;
    }


    public void deleteClazz(Integer id) {
        Clazz clazz = clazzRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Clazz not found with id = " + id));
        clazzRepository.delete(clazz);
    }


    public Clazz getClazzById(Integer id) {
        return clazzRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Clazz not found with id = " + id));
    }

}
