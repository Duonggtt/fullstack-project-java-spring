package com.example.studenmanagewithnuxtjsandspring;

import com.example.studenmanagewithnuxtjsandspring.entity.Role;
import com.example.studenmanagewithnuxtjsandspring.entity.User;
import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertClazzRequest;
import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertMajorRequest;
import com.example.studenmanagewithnuxtjsandspring.model.request.UpsertStudentRequest;
import com.example.studenmanagewithnuxtjsandspring.service.ClazzService;
import com.example.studenmanagewithnuxtjsandspring.service.MajorService;
import com.example.studenmanagewithnuxtjsandspring.service.StudentService;
import com.example.studenmanagewithnuxtjsandspring.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class StudenManageWithNuxtJsAndSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudenManageWithNuxtJsAndSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner run(MajorService majorService, ClazzService clazzService, StudentService studentService,UserService userService) {
        return args -> {
            UpsertMajorRequest request = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            UpsertMajorRequest request2 = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            UpsertMajorRequest request3 = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            UpsertMajorRequest request4 = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            UpsertMajorRequest request5 = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            UpsertMajorRequest request6 = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            UpsertMajorRequest request7 = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            UpsertMajorRequest request8 = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            UpsertMajorRequest request9 = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            UpsertMajorRequest request10 = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            UpsertMajorRequest request11 = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            UpsertMajorRequest request12 = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            UpsertMajorRequest request13 = new UpsertMajorRequest("1asd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",12);
            majorService.createMajor(request);
            majorService.createMajor(request2);
            majorService.createMajor(request3);
            majorService.createMajor(request4);
            majorService.createMajor(request5);
            majorService.createMajor(request6);
            majorService.createMajor(request7);
            majorService.createMajor(request8);
            majorService.createMajor(request9);
            majorService.createMajor(request10);
            majorService.createMajor(request11);
            majorService.createMajor(request12);
            majorService.createMajor(request13);

            UpsertClazzRequest clazzRequest = new UpsertClazzRequest();
            clazzRequest.setClassName("Class A");  // Thiết lập tên của lớp
            clazzRequest.setCourseNum(1);          // Thiết lập số khóa học
            clazzRequest.setAdvisorName("John Doe"); // Thiết lập tên của cố vấn
            clazzRequest.setMonitorName("Alice Smith"); // Thiết lập tên của sinh viên đảm nhiệm vai trò monitor

            UpsertClazzRequest clazzRequest1 = new UpsertClazzRequest();
            clazzRequest1.setClassName("Class A");  // Thiết lập tên của lớp
            clazzRequest1.setCourseNum(1);          // Thiết lập số khóa học
            clazzRequest1.setAdvisorName("John Doe"); // Thiết lập tên của cố vấn
            clazzRequest1.setMonitorName("Alice Smith"); // Thiết lập tên của sinh viên đảm nhiệm vai trò monitor

            UpsertClazzRequest clazzRequest2 = new UpsertClazzRequest();
            clazzRequest2.setClassName("Class A");  // Thiết lập tên của lớp
            clazzRequest2.setCourseNum(1);          // Thiết lập số khóa học
            clazzRequest2.setAdvisorName("John Doe"); // Thiết lập tên của cố vấn
            clazzRequest2.setMonitorName("Alice Smith"); // Thiết lập tên của sinh viên đảm nhiệm vai trò monitor

            // Sử dụng ClazzService để thêm lớp mới vào cơ sở dữ liệu
            clazzService.createClazz(clazzRequest);
            clazzService.createClazz(clazzRequest1);
            clazzService.createClazz(clazzRequest2);


            UpsertStudentRequest studentRequest = new UpsertStudentRequest();
            studentRequest.setFullName("John Doe");
            studentRequest.setBirthDate(new Date());
            studentRequest.setAddress("123 Main Street");
            studentRequest.setAdmissionDate(new Date());
            studentRequest.setGraduationDate(new Date());
            studentRequest.setGender("Male");
            studentRequest.setEmail("john.doe@example.com");
            studentRequest.setPhone("123-456-7890");
            studentRequest.setEthnicity("Asian");
            studentRequest.setGpa(3.5f);
            studentRequest.setStatus("Đang học");
            studentRequest.setMajorId(1);

            UpsertStudentRequest studentRequest2 = new UpsertStudentRequest();
            studentRequest2.setFullName("John Doe");
            studentRequest2.setBirthDate(new Date());
            studentRequest2.setAddress("123 Main Street");
            studentRequest2.setAdmissionDate(new Date());
            studentRequest2.setGraduationDate(new Date());
            studentRequest2.setGender("Male");
            studentRequest2.setEmail("john.doe@example.com");
            studentRequest2.setPhone("123-456-7890");
            studentRequest2.setEthnicity("Asian");
            studentRequest2.setGpa(3.5f);
            studentRequest2.setStatus("Bỏ học");
            studentRequest2.setMajorId(1);


            UpsertStudentRequest studentRequest3 = new UpsertStudentRequest();
            studentRequest3.setFullName("John Doe");
            studentRequest3.setBirthDate(new Date());
            studentRequest3.setAddress("123 Main Street");
            studentRequest3.setAdmissionDate(new Date());
            studentRequest3.setGraduationDate(new Date());
            studentRequest3.setGender("Male");
            studentRequest3.setEmail("john.doe@example.com");
            studentRequest3.setPhone("123-456-7890");
            studentRequest3.setEthnicity("Asian");
            studentRequest3.setGpa(3.5f);
            studentRequest3.setStatus("Bảo lưu");
            studentRequest3.setMajorId(1);

            // Gọi phương thức để thêm sinh viên vào cơ sở dữ liệu
            studentService.createStudent(studentRequest);
            studentService.createStudent(studentRequest2);
            studentService.createStudent(studentRequest3);

            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(null, "Duong", "Duong", "123",new ArrayList<>()));
            userService.saveUser(new User(null, "Dat", "Dat", "123",new ArrayList<>()));
            userService.saveUser(new User(null, "Jonh", "Jonh", "123",new ArrayList<>()));
            userService.saveUser(new User(null, "Tom", "Tom", "123",new ArrayList<>()));
            userService.saveUser(new User(null, "Super Admin", "Admin", "123",new ArrayList<>()));

            userService.addRoleToUser("Duong", "ROLE_USER");
            userService.addRoleToUser("Duong", "ROLE_ADMIN");
            userService.addRoleToUser("Dat", "ROLE_USER");
            userService.addRoleToUser("Dat", "ROLE_ADMIN");
            userService.addRoleToUser("Jonh", "ROLE_USER");
            userService.addRoleToUser("Tom", "ROLE_USER");
            userService.addRoleToUser("Admin", "ROLE_ADMIN");
        };
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
