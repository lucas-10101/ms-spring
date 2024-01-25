package br.com.fullstackdeveloper.hrpayroll.data.entities;

import java.math.BigDecimal;

public class Payment {

    private String name;

    private BigDecimal dailyIncome;

    private Integer days;

    public BigDecimal getTotal() {
        return dailyIncome.multiply(BigDecimal.valueOf(days));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(BigDecimal dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

}
