package br.com.fullstackdeveloper.hrworker;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fullstackdeveloper.hrworker.data.entities.Worker;
import br.com.fullstackdeveloper.hrworker.data.repositories.WorkerRepository;

@SpringBootApplication
public class HrWorkerApplication implements CommandLineRunner {

    @Autowired
    private WorkerRepository workerRepository;

    public static void main(String[] args) {
        SpringApplication.run(HrWorkerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Worker w1 = new Worker();
        w1.setName("Bob");
        w1.setDailyIncome(BigDecimal.valueOf(200));

        Worker w2 = new Worker();
        w2.setName("Maria");
        w2.setDailyIncome(BigDecimal.valueOf(300));

        Worker w3 = new Worker();
        w3.setName("Alex");
        w3.setDailyIncome(BigDecimal.valueOf(250));

        workerRepository.saveAll(Arrays.asList(w1, w2, w3));
    }

}
