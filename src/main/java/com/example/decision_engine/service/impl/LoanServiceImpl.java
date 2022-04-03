package com.example.decision_engine.service.impl;

import com.example.decision_engine.entity.*;
import com.example.decision_engine.repository.UserDetailsRepository;
import com.example.decision_engine.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {
    private final UserDetailsRepository userDetailsRepository;


    @Override
    public String makeLoanRequest (LoanRequest loanRequest ) throws Exception {
        UserDetails userDetails = userDetailsRepository.findByPersonalCode(loanRequest.getPersonalCode());
        if (userDetails == null) {
            String USER_NOT_FOUND = "This user does not exist";
            throw new Exception(USER_NOT_FOUND);
        }
        String decision = approveLoan(userDetails, loanRequest);
        loanRequest.setDecision(decision);
        return decision;
    }

    @Override
    public long calculateCreditScore (int creditModifier, LoanRequest loanRequest) {

        return ((creditModifier/loanRequest.getRequestLoanAmount())* loanRequest.getRequestLoanPeriod());
    }

    @Override
    public String approveLoan (UserDetails userDetails, LoanRequest loanRequest) {
        String LOAN_APPROVED = "Loan approved";
        int minPeriod = Limits.PeriodMin.getValue();
        int minAmount = Limits.AmountMin.getValue();
        int modifier = userDetails.getSegmentation().getValue();
        String LOAN_NOT_APPROVED = "Loan not approved";
        if (modifier == 0) {
            return LOAN_NOT_APPROVED;
        }
        else {
            long creditScore = calculateCreditScore(modifier, loanRequest);

            if (creditScore >= 1) {
                LOAN_APPROVED = "Loan approved";
                return LOAN_APPROVED +" for " + loanRequest.getRequestLoanAmount() +
                        " euros for " + loanRequest.getRequestLoanPeriod() + " months";
            }
            else{
               Double approvedAmount = checkAmount(minPeriod,modifier );
               if(approvedAmount>=Limits.AmountMin.getValue()){
                   return LOAN_APPROVED + "for " + approvedAmount + " euros for " + minPeriod + "months";
               }
               else{
                   Double approvedPeriod = checkPeriod(minAmount, modifier);
                   return LOAN_APPROVED + "for " +  minAmount + " euros for" + approvedPeriod + "months";
               }

            }



        }
    }

    @Override
    public Double checkPeriod (Double creditScore, LoanRequest loanRequest, int modifier) {
        double temp = creditScore *loanRequest.getRequestLoanAmount();
        return temp/modifier;

    }

    @Override
    public Double checkAmount (Double creditScore, LoanRequest loanRequest, int modifier) {
        double temp = modifier * loanRequest.getRequestLoanPeriod();
        return temp/creditScore;
    }

    @Override
    public Double checkPeriod (int amount, int modifier) {
        return (double) (amount / modifier);
    }

    @Override
    public Double checkAmount (int period, int modifier) {
        return (double) ( period * modifier);
    }

}
