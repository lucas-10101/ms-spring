package br.com.fullstackdeveloper.hrpayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackdeveloper.hrpayroll.data.entities.Payment;
import br.com.fullstackdeveloper.hrpayroll.service.PaymentService;

@RestController
@RequestMapping(path = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(path = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Integer workerId, @PathVariable Integer days) {
        return ResponseEntity.ok(paymentService.getPayment(workerId, days));
    }
}
