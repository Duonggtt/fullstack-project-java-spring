package com.example.studenmanagewithnuxtjsandspring.repository;

import com.example.studenmanagewithnuxtjsandspring.entity.Clazz;
import com.example.studenmanagewithnuxtjsandspring.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findById(Integer id);

    @Query("select  c from Course c where "
            + "concat(c.id, c.courseNum)"
            + "LIKE %?1%")
    Page<Course> findAll(String keyword, Pageable pageable);
}
