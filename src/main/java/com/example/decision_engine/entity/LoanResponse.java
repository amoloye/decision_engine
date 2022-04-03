package com.example.decision_engine.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class LoanResponse {
    public LoanDecision loanDecision;
    public Date alternativePeriod;
    public BigDecimal loanAmount;

}
