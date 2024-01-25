package br.com.fullstackdeveloper.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullstackdeveloper.hrpayroll.data.entities.Payment;
import br.com.fullstackdeveloper.hrpayroll.data.entities.Worker;
import br.com.fullstackdeveloper.hrpayroll.data.feign.WorkersFeignClient;

@Service
public class PaymentService {

    @Autowired
    private WorkersFeignClient workersFeignClient;

    public Payment getPayment(Integer workerId, int days) {
        Payment payment = new Payment();

        Worker worker = getWorker(workerId);

        payment.setName(worker.getName());
        payment.setDays(days);
        payment.setDailyIncome(worker.getDailyIncome());

        return payment;
    }

    protected Worker getWorker(Integer workerId) {
        return workersFeignClient.getById(workerId);
    }
}
