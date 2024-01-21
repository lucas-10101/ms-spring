package br.com.fullstackdeveloper.hrworker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackdeveloper.hrworker.data.entities.Worker;
import br.com.fullstackdeveloper.hrworker.data.repositories.WorkerRepository;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(path = "/workers")
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public List<Worker> getAll() {
        return workerRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Worker getById(@PathVariable Integer id) {
        return workerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Worker not found !"));
    }

}
