package br.com.fullstackdeveloper.hrpayroll.service;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fullstackdeveloper.hrpayroll.data.entities.Payment;
import br.com.fullstackdeveloper.hrpayroll.data.entities.Worker;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String hrWorkerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Integer workerId, int days) {
        var payment = new Payment();

        var worker = getWorker(workerId);

        payment.setName(worker.getName());
        payment.setDays(days);
        payment.setDailyIncome(worker.getDailyIncome());

        return payment;
    }

    protected Worker getWorker(Integer workerId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(hrWorkerHost).path("workers/{id}").build(workerId);

        System.out.println("URI: " + uri.toString());

        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<Worker>(createHeaders()), Worker.class).getBody();
    }

    HttpHeaders createHeaders() {
        return new HttpHeaders() {
            private static final long serialVersionUID = 1L;

            {
                String auth = "admin" + ":" + "123";
                byte[] encodedAuth = Base64.getEncoder().encode(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }
}
