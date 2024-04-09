package com.example.studenmanagewithnuxtjsandspring.repository;

import com.example.studenmanagewithnuxtjsandspring.entity.Major;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MajorRepository extends JpaRepository<Major, Integer> {
    Optional<Major> findById(Integer id);

    @Query("select  m from Major m where "
            + "concat(m.id, m.majorName)"
            + "LIKE %?1%")
    Page<Major> findAll(String keyword, Pageable pageable);
}
