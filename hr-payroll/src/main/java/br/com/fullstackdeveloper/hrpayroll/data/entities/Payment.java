package br.com.fullstackdeveloper.hrpayroll.data.entities;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Payment {

    private String name;

    private BigDecimal dailyIncome;

    private Integer days;

    public BigDecimal getTotal() {
        return dailyIncome.multiply(BigDecimal.valueOf(days));
    }
}
