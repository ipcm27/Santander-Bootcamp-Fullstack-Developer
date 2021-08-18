package com.dio.CPonto.controller;

import com.dio.CPonto.entity.WorkLoad;
import com.dio.CPonto.repository.WorkLoadRepository;
import com.dio.CPonto.service.WorkLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/workload")

public class WorkLoadController {

    //https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Methods
    //Post causa uma mudança no estado do recurso no servidor.
    //Put substitui todas as atuais representações do recurso de destino pela carga de dados da requisição.
    //Get solicita a representação de um recurso específico
    //Delete O método DELETE remove um recurso específico.

    @Autowired
    WorkLoadService WorkLoadService;

    @PostMapping
    public WorkLoad createWorkLoad(@RequestBody WorkLoad workLoad){
        return WorkLoadService.save(workLoad);
    }

    //When testing with Postman put an Array to see as a List
    @GetMapping
    public List<WorkLoad> findWorkLoad() {
        return WorkLoadService.findAll();
    }

    @GetMapping("/{workLoadId}")
    public ResponseEntity<WorkLoad> findWorkLoadById(@PathVariable("workLoadId")Long workLoadId) throws Exception {
        return ResponseEntity.ok(WorkLoadService.findById(workLoadId).orElseThrow(() -> new NoSuchElementException("Couldn't find your WorkLoad")));
    }

    @PutMapping
    public WorkLoad updateById(@RequestBody WorkLoad workLoad){
        return WorkLoadService.save(workLoad);
    }

    @DeleteMapping("/{workLoadId}")
    public ResponseEntity deleteById(@PathVariable("workLoadId") Long workLoadId) throws Exception {
        try{
            WorkLoadService.deleteWorkLoad(workLoadId);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<WorkLoad>) ResponseEntity.ok();
    }


}
