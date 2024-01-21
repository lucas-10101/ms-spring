package br.com.fullstackdeveloper.hrworker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fullstackdeveloper.hrworker.data.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

}
