package com.example.decision_engine.service;


import com.example.decision_engine.entity.LoanDecision;
import com.example.decision_engine.entity.UserRequest;


public interface LoanDecisionService {
    LoanDecision createLoanDecision(LoanDecision loanDecision, UserRequest userRequest) throws Exception;

    LoanDecision fetchLoanDecisionByPersonalCode (String personalCode);
}
