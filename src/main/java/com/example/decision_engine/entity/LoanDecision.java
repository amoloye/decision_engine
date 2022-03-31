package com.example.decision_engine.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoanDecision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loanDecisionId;

    @OneToOne
    @JoinColumn(name="userDetailsId")
    private UserDetails userDetails;


    private int creditScore;
    // (credit modifier / loan amount) * loan period

    @Enumerated(EnumType.STRING)
    private DecisionBinary decisionBinary;
    //If the result is less than 1 then we would not approve such sum, if the result is larger or
    //equal than 1 then we would approve this sum.

    private long approvableMinLoan;

    private long approvableMaxLoan;

    private int approvableMinPeriod;

    private  int approvableMaxPeriod;


    //decided amount that can be borrowed to the app user
    private long approvedAmount;


    //decided period(months) the loan can be borrowed to the app user
    private int approvedPeriod;


    public LoanDecision (String personalCode, int i, LoanDecision value, int i1, int i2, int i3, int i4, int i5) {
    }
}
