package br.com.fullstackdeveloper.hrworker.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackdeveloper.hrworker.data.entities.Worker;
import br.com.fullstackdeveloper.hrworker.data.repositories.WorkerRepository;

@RestController
@RequestMapping(path = "/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public List<Worker> getAll() {
        return workerRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Worker getById(@PathVariable Integer id) {

        logger.info("PORT = " + env.getProperty("local.server.port"));

        return workerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Worker not found !"));
    }

}
