package com.example.studenmanagewithnuxtjsandspring.repository;

import com.example.studenmanagewithnuxtjsandspring.entity.Lecturer;
import com.example.studenmanagewithnuxtjsandspring.entity.Major;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer>{
    Optional<Lecturer> findById(Integer id);

    @Query("select  l from Lecturer l where "
            + "concat(l.id, l.fullName, l.phone)"
            + "LIKE %?1%")
    Page<Lecturer> findAll(String keyword, Pageable pageable);
}
