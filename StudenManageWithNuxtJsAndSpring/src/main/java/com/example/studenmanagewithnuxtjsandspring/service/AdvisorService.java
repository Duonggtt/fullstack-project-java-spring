package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.Advisor;
import com.example.studenmanagewithnuxtjsandspring.entity.Gender;
import com.example.studenmanagewithnuxtjsandspring.exception.NotFoundException;
import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertAdvisorRequest;
import com.example.studenmanagewithnuxtjsandspring.repository.AdvisorRepository;
import com.example.studenmanagewithnuxtjsandspring.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvisorService {
    @Autowired
    private AdvisorRepository advisorRepository;

    @Autowired
    private GenderRepository genderRepository;

    public Page<Advisor> getAllAdvisors(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return advisorRepository.findAll(pageRequest);
    }

    public Page<Advisor> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<Advisor> advisorPage;
        if(keyword != null) {
            advisorPage = advisorRepository.findAll(keyword,pageable);
        }else {
            advisorPage = advisorRepository.findAll(pageable);
        }

        List<Advisor> advisorList = advisorPage.getContent();

        return new PageImpl<>(advisorList, pageable, advisorPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public Advisor createAdvisor(UpsertAdvisorRequest request) {
        Gender gender = genderRepository.findById(request.getGenderId())
                .orElseThrow(() -> new NotFoundException("Gender not found with id = " + request.getGenderId()));

        Advisor advisor = new Advisor();
        advisor.setName(request.getName());
        advisor.setEmail(request.getEmail());
        advisor.setPhone(request.getPhone());
        advisor.setGender(gender);
        advisorRepository.save(advisor);
        return advisor;
    }

    public Advisor updateAdvisor(Integer id ,UpsertAdvisorRequest request) {
        Gender gender = genderRepository.findById(request.getGenderId())
                .orElseThrow(() -> new NotFoundException("Gender not found with id = " + request.getGenderId()));

        Advisor advisor = advisorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Advisor not found with id = " + id));
        advisor.setName(request.getName());
        advisor.setEmail(request.getEmail());
        advisor.setPhone(request.getPhone());
        advisor.setGender(gender);
        advisorRepository.save(advisor);
        return advisor;
    }

    public void deleteAdvisor(Integer id) {
        Advisor advisor = advisorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Advisor not found with id = " + id));
        advisorRepository.delete(advisor);
    }


    public Advisor getAdvisorById(Integer id) {
        return advisorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Advisor not found with id = " + id));
    }

    public List<Advisor> getAdvisors() {
        return advisorRepository.findAll();
    }
}
