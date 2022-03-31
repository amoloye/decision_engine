package com.example.decision_engine.entity;


import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class UserRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userRequestId;

    @NotEmpty(message = "input personal code")
    private String personalCode;

    @Size(min =2000,max = 10000)
    @NotEmpty(message = "input loan amount")
    private long requestLoanAmount;

    @Size(min = 12,max = 60)
    @NotEmpty(message = "input loan period in months")
    private int requestLoanPeriod;


}
