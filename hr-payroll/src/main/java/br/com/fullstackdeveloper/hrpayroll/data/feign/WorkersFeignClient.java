package br.com.fullstackdeveloper.hrpayroll.data.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.fullstackdeveloper.hrpayroll.data.entities.Worker;

@Component
@FeignClient(name = "hr-worker", url = "localhost:4444", path = "/workers")
public interface WorkersFeignClient {

    @GetMapping(path = "/{id}")
    public Worker getById(@PathVariable Integer id);
}
