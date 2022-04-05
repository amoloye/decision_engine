package com.example.decision_engine.entity;


import lombok.*;
import org.hibernate.validator.constraints.Range;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class LoanRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userRequestId;

    @NotBlank(message = "input personal code")
    private String personalCode;

    @Range(min =2000,max = 10000)
    @NotNull
    private int requestLoanAmount;

    @Range(min = 12,max = 60)
    @NotNull
    private int requestLoanPeriod;

    private String decision;
}
