package br.com.fullstackdeveloper.hrpayroll.data.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private BigDecimal dailyIncome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
