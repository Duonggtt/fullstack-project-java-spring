package com.example.studenmanagewithnuxtjsandspring.repository;

import com.example.studenmanagewithnuxtjsandspring.entity.Student;
import com.example.studenmanagewithnuxtjsandspring.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject , Integer> {
    @Query("select  s from Subject s where "
            + "concat(s.id, s.name)"
            + "LIKE %?1%")
    Page<Subject> findAll(String keyword, Pageable pageable);
}
