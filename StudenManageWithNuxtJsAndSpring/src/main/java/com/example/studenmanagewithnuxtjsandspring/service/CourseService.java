package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.Advisor;
import com.example.studenmanagewithnuxtjsandspring.entity.Course;
import com.example.studenmanagewithnuxtjsandspring.entity.Gender;
import com.example.studenmanagewithnuxtjsandspring.exception.NotFoundException;
import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertAdvisorRequest;
import com.example.studenmanagewithnuxtjsandspring.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Page<Course> getAllCourses(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return courseRepository.findAll(pageRequest);
    }

    public Page<Course> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<Course> coursePage;
        if(keyword != null) {
            coursePage = courseRepository.findAll(keyword,pageable);
        }else {
            coursePage = courseRepository.findAll(pageable);
        }

        List<Course> courseList = coursePage.getContent();

        return new PageImpl<>(courseList, pageable, coursePage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public Course createCourse(Course request) {
        Course course = new Course();
        course.setCourseNum(request.getCourseNum());
        courseRepository.save(course);
        return course;
    }

    public Course updateCourse(Integer id ,Course request) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with id = " + id));

        course.setCourseNum(request.getCourseNum());
        courseRepository.save(course);
        return course;
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with id = " + id));
        courseRepository.delete(course);
    }


    public Course getCourseById(Integer id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with id = " + id));
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

}
