package com.example.decision_engine.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    public void setLoanHistory (LoanRequest loanRequest) {
        this.loanHistory.add(loanRequest);
    }

    public UserDetails (String personalCode, Segmentation segmentation) {
        this.personalCode = personalCode;
        this.segmentation = segmentation;

    }
}
