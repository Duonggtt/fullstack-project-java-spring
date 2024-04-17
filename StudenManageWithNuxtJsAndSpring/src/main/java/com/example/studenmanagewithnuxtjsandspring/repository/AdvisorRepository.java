package com.example.studenmanagewithnuxtjsandspring.repository;

import com.example.studenmanagewithnuxtjsandspring.entity.Advisor;
import com.example.studenmanagewithnuxtjsandspring.entity.Clazz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvisorRepository extends JpaRepository<Advisor, Integer>{
    Optional<Advisor> findById(Integer id);

    @Query("select a from Advisor a where "
            + "concat(a.id, a.name, a.email, a.phone)"
            + "LIKE %?1%")
    Page<Advisor> findAll(String keyword, Pageable pageable);
}
