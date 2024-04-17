package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.Gender;
import com.example.studenmanagewithnuxtjsandspring.exception.NotFoundException;
import com.example.studenmanagewithnuxtjsandspring.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    public Gender createGender(Gender request) {
        Gender gender = new Gender();
        gender.setGenderName(request.getGenderName());
        genderRepository.save(gender);
        return gender;
    }

    public Gender updateGender(Integer id , Gender request) {
        Gender gender = genderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gender not found with id = " + id));

        gender.setGenderName(request.getGenderName());
        return gender;
    }

    public void deleteGender(Integer id) {
        Gender gender = genderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gender not found with id = " + id));
        genderRepository.delete(gender);
    }


    public Gender getGenderById(Integer id) {
        return genderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gender not found with id = " + id));
    }

    public List<Gender> getGenders() {
        return genderRepository.findAll();
    }
}
