package com.example.decision_engine.controller;


import com.example.decision_engine.entity.LoanDecision;
import com.example.decision_engine.service.LoanDecisionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LoanDecisionController {
    private final LoanDecisionService loanDecisionService;


    @GetMapping("/decision")
    public LoanDecision fetchLoanDecision(String personalCode){
        return  loanDecisionService.fetchLoanDecisionByPersonalCode(personalCode);
    }

}
