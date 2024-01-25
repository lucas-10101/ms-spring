package br.com.fullstackdeveloper.hrpayroll.data.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private BigDecimal dailyIncome;
}
