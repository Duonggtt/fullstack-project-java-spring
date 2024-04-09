package com.example.studenmanagewithnuxtjsandspring.repository;

import com.example.studenmanagewithnuxtjsandspring.entity.Clazz;
import com.example.studenmanagewithnuxtjsandspring.entity.Major;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
    Optional<Clazz> findById(Integer id);

    @Query("select  c from Clazz c where "
            + "concat(c.id, c.className,c.courseNum)"
            + "LIKE %?1%")
    Page<Clazz> findAll(String keyword, Pageable pageable);
}
