package com.dio.CPonto.service;

import com.dio.CPonto.entity.WorkLoad;
import com.dio.CPonto.repository.WorkLoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkLoadService {


    WorkLoadRepository WorkLoadRepository;

    @Autowired
    public WorkLoadService(com.dio.CPonto.repository.WorkLoadRepository workLoadRepository) {
        WorkLoadRepository = workLoadRepository;
    }

    //CRUD
    public WorkLoad save(WorkLoad workLoad){
        return WorkLoadRepository.save(workLoad);
    }

    public List<WorkLoad> findAll() {
        return   WorkLoadRepository.findAll();
    }

    public Optional<WorkLoad> findById(Long workLoadId) {
        return WorkLoadRepository.findById(workLoadId);
    }

    public void deleteWorkLoad(Long workLoadId) {
        WorkLoadRepository.deleteById(workLoadId);
    }
}
