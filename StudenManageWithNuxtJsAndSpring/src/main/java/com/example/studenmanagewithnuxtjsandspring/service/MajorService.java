package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.Major;
import com.example.studenmanagewithnuxtjsandspring.exception.NotFoundException;
import com.example.studenmanagewithnuxtjsandspring.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {
    @Autowired
    private MajorRepository majorRepository;

    public Page<Major> getAllMajors(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return majorRepository.findAll(pageRequest);
    }

    public Page<Major> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<Major> majorPage;
        if(keyword != null) {
            majorPage = majorRepository.findAll(keyword,pageable);
        }else {
            majorPage = majorRepository.findAll(pageable);
        }

        List<Major> majorList = majorPage.getContent();

        return new PageImpl<>(majorList, pageable, majorPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public Major createMajor(Major request) {
        Major major = new Major();
        major.setMajorName(request.getMajorName());
        major.setDetail(request.getDetail());
        major.setYearQuantity(request.getYearQuantity());
        majorRepository.save(major);
        return major;
    }

    public Major updateMajor(Major request, Integer id) {
        Major major = majorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Major not found with id = " + id));

        major.setMajorName(request.getMajorName());
        major.setDetail(request.getDetail());
        major.setYearQuantity(request.getYearQuantity());
        majorRepository.save(major);
        return major;
    }

    public void deleteMajor(Integer id) {
        Major major = majorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Major not found with id = " + id));
        majorRepository.delete(major);
    }


    public Major getMajorById(Integer id) {
        return majorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Major not found with id = " + id));
    }

    public List<Major> getMajors() {
        return majorRepository.findAll();
    }
}
