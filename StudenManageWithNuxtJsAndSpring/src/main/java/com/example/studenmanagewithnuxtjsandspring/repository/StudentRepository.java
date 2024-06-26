package com.example.studenmanagewithnuxtjsandspring.repository;

import com.example.studenmanagewithnuxtjsandspring.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByIdIn(List<Integer> categoryIds);
    @Query("select  s from Student s where "
            + "concat(s.id, s.fullName, s.cmnd)"
            + "LIKE %?1%")
    Page<Student> findAll(String keyword, Pageable pageable);
}
