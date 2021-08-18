package com.dio.CPonto.repository;


import com.dio.CPonto.entity.WorkLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkLoadRepository extends JpaRepository<WorkLoad,Long> {

}
