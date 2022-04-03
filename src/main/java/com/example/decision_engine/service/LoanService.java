package com.example.decision_engine.service;


import com.example.decision_engine.entity.LoanRequest;
import com.example.decision_engine.entity.UserDetails;

import java.math.BigDecimal;


public interface LoanService {
    String makeLoanRequest (LoanRequest loanRequest) throws Exception;
    long calculateCreditScore(int creditModifier, LoanRequest loanRequest );
    String approveLoan (UserDetails userDetails, LoanRequest loanRequest);
    Double checkPeriod (Double creditScore, LoanRequest loanRequest, int modifier);
    Double checkAmount (Double creditScore, LoanRequest loanRequest, int modifier);
    Double checkPeriod (int amount, int modifier);
    Double checkAmount (int period, int modifier);

}
