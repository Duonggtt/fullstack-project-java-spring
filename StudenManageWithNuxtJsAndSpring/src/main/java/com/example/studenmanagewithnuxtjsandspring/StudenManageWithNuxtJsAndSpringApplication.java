package com.example.studenmanagewithnuxtjsandspring;

import com.example.studenmanagewithnuxtjsandspring.entity.*;
import com.example.studenmanagewithnuxtjsandspring.model.request.*;
import com.example.studenmanagewithnuxtjsandspring.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class StudenManageWithNuxtJsAndSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudenManageWithNuxtJsAndSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner run(GradeScaleService gradeScaleService,LecturerService lecturerService, GenderService genderService,AcademicYearService academicYearService, AdvisorService advisorService,CourseService courseService ,MajorService majorService, ClazzService clazzService, StudentService studentService, UserService userService, SubjectService subjectService, PointService pointService) {
        return args -> {

            InsertData insertData = new InsertData();
            insertData.addGenders(genderService);
            insertData.addGradeScale(gradeScaleService);
            insertData.addAdvisors(advisorService);
            insertData.addMajors(majorService);
            insertData.addCourses(courseService);
            insertData.addAcademicYears(academicYearService);
            insertData.addClazzs(clazzService);
            insertData.addSubjects(subjectService);
            insertData.addLecturers(lecturerService);
            insertData.addStudents(studentService);
            insertData.addPoints(pointService);
            insertData.addUserRoles(userService);
        };
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
