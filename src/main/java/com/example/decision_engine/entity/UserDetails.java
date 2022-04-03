package com.example.decision_engine.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userDetailsId;

    @NotEmpty
    private String personalCode;

    //enum
    @Enumerated(EnumType.STRING)
    private Segmentation segmentation;

    //loanhistory
    @OneToMany
    @JoinColumn(name="userRequestId")
   private List<LoanRequest> loanHistory;

    public void setLoanHistory (LoanRequest request) {
        this.loanHistory.add(request);
    }
}
