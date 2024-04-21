package com.example.studenmanagewithnuxtjsandspring;

import com.example.studenmanagewithnuxtjsandspring.entity.*;
import com.example.studenmanagewithnuxtjsandspring.model.request.*;
import com.example.studenmanagewithnuxtjsandspring.service.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertData {
    public void addGenders(GenderService genderService) {
        //add gender
        Gender male = new Gender(null, "Male");
        Gender female = new Gender(null, "Female");
        genderService.createGender(male);
        genderService.createGender(female);
    }

    public void addGradeScale(GradeScaleService gradeScaleService) {
        GradeScale gradeScaleA = new GradeScale(null,"A",9.0f,10.0f);
        GradeScale gradeScaleB = new GradeScale(null,"B",8.5f,9.0f);
        GradeScale gradeScaleC = new GradeScale(null,"C",7.0f,8.5f);
        GradeScale gradeScaleD = new GradeScale(null,"D",5.5f,7.0f);
        GradeScale gradeScaleF = new GradeScale(null,"F",0.0f,5.5f);
        gradeScaleService.createGrade(gradeScaleA);
        gradeScaleService.createGrade(gradeScaleB);
        gradeScaleService.createGrade(gradeScaleC);
        gradeScaleService.createGrade(gradeScaleD);
        gradeScaleService.createGrade(gradeScaleF);
    }

    public void addAdvisors(AdvisorService advisorService) {
        //add advisor co van
        UpsertAdvisorRequest advisor = new UpsertAdvisorRequest("Nguyễn Văn A","a123@gmail.com","1234567890",1);
        UpsertAdvisorRequest advisor1 = new UpsertAdvisorRequest("Trần Thị B","b123@gmail.com","1234567890",2);
        UpsertAdvisorRequest advisor2 = new UpsertAdvisorRequest("Lê Văn C","c123@gmail.com","1234567890",1);
        UpsertAdvisorRequest advisor3 = new UpsertAdvisorRequest("Phạm Thị D","d123@gmail.com","1234567890",2);
        UpsertAdvisorRequest advisor4 = new UpsertAdvisorRequest("Hoàng Văn E","e123@gmail.com","1234567890",1);
        UpsertAdvisorRequest advisor5 = new UpsertAdvisorRequest("Đặng Thị F","f123@gmail.com","1234567890",2);
        UpsertAdvisorRequest advisor6 = new UpsertAdvisorRequest("Vũ Văn G","g123@gmail.com","1234567890",1);
        UpsertAdvisorRequest advisor7 = new UpsertAdvisorRequest("Bùi Thị H","h123@gmail.com","1234567890",2);
        UpsertAdvisorRequest advisor8 = new UpsertAdvisorRequest("Le Ngoc I","i123@gmail.com","1234567890",2);
        advisorService.createAdvisor(advisor);
        advisorService.createAdvisor(advisor1);
        advisorService.createAdvisor(advisor2);
        advisorService.createAdvisor(advisor3);
        advisorService.createAdvisor(advisor4);
        advisorService.createAdvisor(advisor5);
        advisorService.createAdvisor(advisor6);
        advisorService.createAdvisor(advisor7);
        advisorService.createAdvisor(advisor8);
    }

    public void addMajors(MajorService majorService) {
        //add nganh hoc
        Major major = new Major(null,"CNTT","detail",5);
        Major major1 = new Major(null,"QTKD","detail",3);
        Major major2 = new Major(null,"CNTP","detail",4);
        Major major3 = new Major(null,"LUAT","detail",4);
        Major major4 = new Major(null,"MKT","detail",4);
        Major major5 = new Major(null,"NNA","detail",3);
        Major major6 = new Major(null,"QTNL","detail",4);
        Major major7 = new Major(null,"KS","detail",4);
        Major major8 = new Major(null,"YTE","detail",8);

        majorService.createMajor(major);
        majorService.createMajor(major1);
        majorService.createMajor(major2);
        majorService.createMajor(major3);
        majorService.createMajor(major4);
        majorService.createMajor(major5);
        majorService.createMajor(major6);
        majorService.createMajor(major7);
        majorService.createMajor(major8);

    }

    public void addCourses(CourseService courseService) {
        //add khoa hoc
        Course course = new Course(null,12);
        Course course1 = new Course(null,10);
        Course course2 = new Course(null,11);
        Course course3 = new Course(null,13);
        Course course4 = new Course(null,14);
        Course course5 = new Course(null,15);
        courseService.createCourse(course);
        courseService.createCourse(course1);
        courseService.createCourse(course2);
        courseService.createCourse(course3);
        courseService.createCourse(course4);
        courseService.createCourse(course5);
    }

    public void addAcademicYears(AcademicYearService academicYearService) {
        //add nam hoc
        AcademicYear academicYear = new AcademicYear(null,"2020-2021");
        AcademicYear academicYear1 = new AcademicYear(null,"2021-2025");
        AcademicYear academicYear2 = new AcademicYear(null,"2022-2026");
        AcademicYear academicYear3 = new AcademicYear(null,"2023-2027");
        AcademicYear academicYear4 = new AcademicYear(null,"2024-2028");
        AcademicYear academicYear5 = new AcademicYear(null,"2025-2029");
        academicYearService.createAcademicYear(academicYear);
        academicYearService.createAcademicYear(academicYear1);
        academicYearService.createAcademicYear(academicYear2);
        academicYearService.createAcademicYear(academicYear3);
        academicYearService.createAcademicYear(academicYear4);
        academicYearService.createAcademicYear(academicYear5);
    }

    public void addClazzs(ClazzService clazzService) {
        //add lop hoc
        UpsertClazzRequest clazzRequest = new UpsertClazzRequest("CNTT12.10.2",1,2, List.of(1,2));
        UpsertClazzRequest clazzRequest1 = new UpsertClazzRequest("CNTT12.10.3",1,2, List.of(3,4));
        UpsertClazzRequest clazzRequest2 = new UpsertClazzRequest("LUAT11.10.4",2,2, List.of(5,6,4,1));
        UpsertClazzRequest clazzRequest3 = new UpsertClazzRequest("CNTT12.10.5",2,1, List.of(7,8,6,2,1));
        UpsertClazzRequest clazzRequest4 = new UpsertClazzRequest("LUAT11.10.6",3,4, List.of(1,4,3));
        UpsertClazzRequest clazzRequest5 = new UpsertClazzRequest("CNTT12.10.7",1,3, List.of(2,1,4,5));
        UpsertClazzRequest clazzRequest6 = new UpsertClazzRequest("LUAT11.10.8",2,4, List.of(2,1,4,6));
        UpsertClazzRequest clazzRequest7 = new UpsertClazzRequest("CNTT12.10.9",1,2, List.of(2,1));
        UpsertClazzRequest clazzRequest8 = new UpsertClazzRequest("CNTT12.10.30",1,2, List.of(2,3,4));
        UpsertClazzRequest clazzRequest9 = new UpsertClazzRequest("QTKD11.10.40",4,3, List.of(2,4,3));
        UpsertClazzRequest clazzRequest10 = new UpsertClazzRequest("QTKD11.10.20",5,2, List.of(2,1,4,3));
        UpsertClazzRequest clazzRequest11 = new UpsertClazzRequest("CNTT12.10.11",2,2, List.of(2,1,8,3));
        UpsertClazzRequest clazzRequest12 = new UpsertClazzRequest("YTE11.10.12",3,1, List.of(1,4,3));
        UpsertClazzRequest clazzRequest13 = new UpsertClazzRequest("LUAT11.10.13",5,2, List.of(2,5,1,4,7));
        UpsertClazzRequest clazzRequest14 = new UpsertClazzRequest("CNTT12.10.14",5,1, List.of(2,6,1,4,3));
        UpsertClazzRequest clazzRequest15 = new UpsertClazzRequest("YTE11.10.15",5,2, List.of(2,1,4,3));
        clazzService.createClazz(clazzRequest);
        clazzService.createClazz(clazzRequest1);
        clazzService.createClazz(clazzRequest2);
        clazzService.createClazz(clazzRequest3);
        clazzService.createClazz(clazzRequest4);
        clazzService.createClazz(clazzRequest5);
        clazzService.createClazz(clazzRequest6);
        clazzService.createClazz(clazzRequest7);
        clazzService.createClazz(clazzRequest8);
        clazzService.createClazz(clazzRequest9);
        clazzService.createClazz(clazzRequest10);
        clazzService.createClazz(clazzRequest11);
        clazzService.createClazz(clazzRequest12);
        clazzService.createClazz(clazzRequest13);
        clazzService.createClazz(clazzRequest14);
        clazzService.createClazz(clazzRequest15);
    }

    public void addSubjects(SubjectService subjectService) {
        //add mon hoc
        Subject subject = new Subject(null,"Math", "none");
        Subject subject1 = new Subject(null,"Literature", "none");
        Subject subject2 = new Subject(null,"History", "none");
        Subject subject3 = new Subject(null,"Geography", "none");
        Subject subject4 = new Subject(null,"Physics", "none");
        Subject subject5 = new Subject(null,"Chemistry", "none");
        Subject subject6 = new Subject(null,"Biology", "none");
        Subject subject7 = new Subject(null,"English", "none");
        Subject subject8 = new Subject(null,"Computer", "none");
        Subject subject9 = new Subject(null,"Physical Education", "none");
        Subject subject10 = new Subject(null,"Music", "none");
        Subject subject11 = new Subject(null,"Art", "none");
        Subject subject12 = new Subject(null,"Technology", "none");
        Subject subject13 = new Subject(null,"Ethics", "none");
        Subject subject14 = new Subject(null,"Citizenship Education", "none");
        Subject subject15 = new Subject(null,"Science", "none");
        Subject subject16 = new Subject(null,"Informatics", "none");
        subjectService.createSubject(subject);
        subjectService.createSubject(subject1);
        subjectService.createSubject(subject2);
        subjectService.createSubject(subject3);
        subjectService.createSubject(subject4);
        subjectService.createSubject(subject5);
        subjectService.createSubject(subject6);
        subjectService.createSubject(subject7);
        subjectService.createSubject(subject8);
        subjectService.createSubject(subject9);
        subjectService.createSubject(subject10);
        subjectService.createSubject(subject11);
        subjectService.createSubject(subject12);
        subjectService.createSubject(subject13);
        subjectService.createSubject(subject14);
        subjectService.createSubject(subject15);
        subjectService.createSubject(subject16);
    }

    public void addLecturers(LecturerService lecturerService) {
        //add lecturer giang vien
        UpsertLecturerRequest lecturer = new UpsertLecturerRequest("Nguyễn Văn A","a123@gmail.com","1234567890",1, List.of(1,2,5,7,9));
        UpsertLecturerRequest lecturer1 = new UpsertLecturerRequest("Trần Văn B","b123@gmail.com","1234123890",1, List.of(11,2,5));
        UpsertLecturerRequest lecturer2 = new UpsertLecturerRequest("Nguyễn Thị C","c123@gmail.com","1234543890",1, List.of(12,8,10,2,5));
        UpsertLecturerRequest lecturer3 = new UpsertLecturerRequest("Trần Văn D","d123@gmail.com","1234562890",1, List.of(2,5));
        UpsertLecturerRequest lecturer4 = new UpsertLecturerRequest("Lê Văn E","e123@gmail.com","1234654890",1, List.of(1,2,3,11,15,13));
        UpsertLecturerRequest lecturer5 = new UpsertLecturerRequest("Trần Văn F","f123@gmail.com","1234127890",1, List.of(2,5,7,9,11,13,15,16));
        UpsertLecturerRequest lecturer6 = new UpsertLecturerRequest("Nguyễn Văn G","g123@gmail.com","1234555890",1, List.of(1,2,5,3,6,4,8,10));
        UpsertLecturerRequest lecturer7 = new UpsertLecturerRequest("Lê Văn H","h123@gmail.com","1234522890",1, List.of(1,2,5,11,12,14));
        UpsertLecturerRequest lecturer8 = new UpsertLecturerRequest("Trần Văn Y","i123@gmail.com","1231167890",1, List.of(3,5,12,14,15));
        UpsertLecturerRequest lecturer9 = new UpsertLecturerRequest("Nguyễn Văn K","k123@gmail.com","1265567890",1, List.of(5,2,6,12,9));
        UpsertLecturerRequest lecturer10 = new UpsertLecturerRequest("Lê Văn L","l123@gmail.com","1134562890",1, List.of(8,3,7,6,5));
        UpsertLecturerRequest lecturer11 = new UpsertLecturerRequest("Trần Văn M","m123@gmail.com","2134567890",1, List.of(11,12,15,5));
        UpsertLecturerRequest lecturer12 = new UpsertLecturerRequest("Lê Văn N","n123@gmail.com","1234327890",1, List.of(2,4,6,8,11,12));
        UpsertLecturerRequest lecturer13 = new UpsertLecturerRequest("Nguyễn Văn O","o123@gmail.com","1234444890",1, List.of(14,2,8,12,16,4));
        lecturerService.createLecturer(lecturer);
        lecturerService.createLecturer(lecturer1);
        lecturerService.createLecturer(lecturer2);
        lecturerService.createLecturer(lecturer3);
        lecturerService.createLecturer(lecturer4);
        lecturerService.createLecturer(lecturer5);
        lecturerService.createLecturer(lecturer6);
        lecturerService.createLecturer(lecturer7);
        lecturerService.createLecturer(lecturer8);
        lecturerService.createLecturer(lecturer9);
        lecturerService.createLecturer(lecturer10);
        lecturerService.createLecturer(lecturer11);
        lecturerService.createLecturer(lecturer12);
        lecturerService.createLecturer(lecturer13);
    }

    public void addStudents(StudentService studentService) {
        //add student sinh vien
        UpsertStudentRequest studentRequest = new UpsertStudentRequest("Nguyễn Văn A",new Date(),"Hà Nội","a111@eaut.edu.vn","1234117890","121456789", "Kinh", "Đang học",1,1,1);
        UpsertStudentRequest studentRequest1 = new UpsertStudentRequest("Lê Văn B",new Date(),"Nam Định","a112@eaut.edu.vn","1234527890","123256789", "Kinh", "Đang học",1,2,2);
        UpsertStudentRequest studentRequest2 = new UpsertStudentRequest("Nguyễn Văn V",new Date(),"Hải Phòng","a113@eaut.edu.vn","1224567890","123456789", "Kinh", "Đang học",2,2,2);
        UpsertStudentRequest studentRequest3 = new UpsertStudentRequest("Nguyễn Bùi Văn D",new Date(),"Hà Nội","a114@eaut.edu.vn","1234547890","124456789", "Kinh", "Đang học",1,3,2);
        UpsertStudentRequest studentRequest4 = new UpsertStudentRequest("Nguyễn Văn E",new Date(),"Nam Định","a115@eaut.edu.vn","1234562190","123556789", "Kinh", "Đang học",2,1,1);
        UpsertStudentRequest studentRequest5 = new UpsertStudentRequest("Bùi Văn F",new Date(),"Hà Nội","a116@eaut.edu.vn","1234555890","123466789", "Kinh", "Đang học",2,4,1);
        UpsertStudentRequest studentRequest6 = new UpsertStudentRequest("Nguyễn Văn G",new Date(),"Hà Nội","a117@eaut.edu.vn","1234667890","127456789", "Kinh", "Đang học",2,5,4);
        UpsertStudentRequest studentRequest7 = new UpsertStudentRequest("Đào Văn H",new Date(),"Hà Nội","a118@eaut.edu.vn","1234127890","123486789", "Kinh", "Đang học",1,3,4);
        UpsertStudentRequest studentRequest8 = new UpsertStudentRequest("Nguyễn Văn J",new Date(),"Thái Bình","a119@eaut.edu.vn","1235437890","129456789", "Kinh", "Đang học",2,1,5);
        UpsertStudentRequest studentRequest9 = new UpsertStudentRequest("Bùi Văn K",new Date(),"Hà Nội","a120@eaut.edu.vn","1234566660","123406789", "Kinh", "Đang học",1,1,1);
        UpsertStudentRequest studentRequest10 = new UpsertStudentRequest("Nguyễn Văn L",new Date(),"Sài Gòn","a121@eaut.edu.vn","1232267890","123456781", "Kinh", "Đang học",2,1,1);
        UpsertStudentRequest studentRequest11 = new UpsertStudentRequest("Trần Văn M",new Date(),"Hà Nội","a122@eaut.edu.vn","1231237890","123456729", "Kinh", "Đang học",1,2,6);
        UpsertStudentRequest studentRequest12 = new UpsertStudentRequest("Đào Văn N",new Date(),"Hà Nội","a123@eaut.edu.vn","1234123490","123456739", "Kinh", "Đang học",1,2,3);
        UpsertStudentRequest studentRequest13 = new UpsertStudentRequest("Nguyễn Văn Y",new Date(),"Hải Phòng","a124@eaut.edu.vn","1432457890","123456749", "Kinh", "Đang học",2,1,7);
        UpsertStudentRequest studentRequest14 = new UpsertStudentRequest("Nguyễn Văn U",new Date(),"Hà Nội","a125@eaut.edu.vn","1234511890","123456759", "Kinh", "Đang học",2,4,2);
        UpsertStudentRequest studentRequest15 = new UpsertStudentRequest("Lê Văn I",new Date(),"Hải Phòng","a126@eaut.edu.vn","1234777890","123456769", "Kinh", "Đang học",1,3,1);
        UpsertStudentRequest studentRequest16 = new UpsertStudentRequest("Nguyễn Thị O",new Date(),"Hà Nội","a127@eaut.edu.vn","1234867890","123456779", "Kinh", "Đang học",2,3,8);
        UpsertStudentRequest studentRequest17 = new UpsertStudentRequest("Trần Văn Q",new Date(),"Thái Bình","a128@eaut.edu.vn","1239967890","12345679x9", "Kinh", "Đang học",1,1,1);
        studentService.createStudent(studentRequest);
        studentService.createStudent(studentRequest1);
        studentService.createStudent(studentRequest2);
        studentService.createStudent(studentRequest3);
        studentService.createStudent(studentRequest4);
        studentService.createStudent(studentRequest5);
        studentService.createStudent(studentRequest6);
        studentService.createStudent(studentRequest7);
        studentService.createStudent(studentRequest8);
        studentService.createStudent(studentRequest9);
        studentService.createStudent(studentRequest10);
        studentService.createStudent(studentRequest11);
        studentService.createStudent(studentRequest12);
        studentService.createStudent(studentRequest13);
        studentService.createStudent(studentRequest14);
        studentService.createStudent(studentRequest15);
        studentService.createStudent(studentRequest16);
        studentService.createStudent(studentRequest17);
    }

    public void addPoints(PointService pointService) {
        UpsertPointRequest pointRequest = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 1,1);
        UpsertPointRequest pointRequest2 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 6,2);
        UpsertPointRequest pointRequest3 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, false, 1,3);
        UpsertPointRequest pointRequest4 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 2,1);
        UpsertPointRequest pointRequest5 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, false, 2,2);
        UpsertPointRequest pointRequest6 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, false, 2,3);
        UpsertPointRequest pointRequest7 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 3,1);
        UpsertPointRequest pointRequest8 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 7,12);
        UpsertPointRequest pointRequest9 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 11,2);
        UpsertPointRequest pointRequest10 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 3,13);
        UpsertPointRequest pointRequest11 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 9,2);
        UpsertPointRequest pointRequest12 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 14,1);
        UpsertPointRequest pointRequest13 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 17,3);
        UpsertPointRequest pointRequest14 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 3,2);
        UpsertPointRequest pointRequest15 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 17,13);
        UpsertPointRequest pointRequest16 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 15,12);
        UpsertPointRequest pointRequest17 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 3,16);
        UpsertPointRequest pointRequest18 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 5,2);
        UpsertPointRequest pointRequest19 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 3,17);
        UpsertPointRequest pointRequest20 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 15,2);
        UpsertPointRequest pointRequest21 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 13,2);
        UpsertPointRequest pointRequest22 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 3,1);
        UpsertPointRequest pointRequest23 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 14,12);
        UpsertPointRequest pointRequest24 = new UpsertPointRequest( 8.5f, 7.5f, 9.0f, true, 11,11);
        pointService.createPoint(pointRequest);
        pointService.createPoint(pointRequest2);
        pointService.createPoint(pointRequest3);
        pointService.createPoint(pointRequest4);
        pointService.createPoint(pointRequest5);
        pointService.createPoint(pointRequest6);
        pointService.createPoint(pointRequest7);
        pointService.createPoint(pointRequest8);
        pointService.createPoint(pointRequest9);
        pointService.createPoint(pointRequest10);
        pointService.createPoint(pointRequest11);
        pointService.createPoint(pointRequest12);
        pointService.createPoint(pointRequest13);
        pointService.createPoint(pointRequest14);
        pointService.createPoint(pointRequest15);
        pointService.createPoint(pointRequest16);
        pointService.createPoint(pointRequest17);
        pointService.createPoint(pointRequest18);
        pointService.createPoint(pointRequest19);
        pointService.createPoint(pointRequest20);
        pointService.createPoint(pointRequest21);
        pointService.createPoint(pointRequest22);
        pointService.createPoint(pointRequest23);
        pointService.createPoint(pointRequest24);
    }

    public void addUserRoles(UserService userService) {
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
    }
}
