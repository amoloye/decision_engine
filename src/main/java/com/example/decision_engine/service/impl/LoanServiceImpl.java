package com.example.decision_engine.service.impl;

import com.example.decision_engine.entity.*;
import com.example.decision_engine.exception.UserNotFoundException;
import com.example.decision_engine.repository.UserDetailsRepository;
import com.example.decision_engine.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {
    private final UserDetailsRepository userDetailsRepository;


    @Override
    public String makeLoanRequest (LoanRequest loanRequest ) throws UserNotFoundException {
        UserDetails userDetails = userDetailsRepository.findByPersonalCode(loanRequest.getPersonalCode());
        if (userDetails == null) {
            throw new UserNotFoundException("User not found with personal code: " + loanRequest.getPersonalCode());
        }
         String decision = approveLoan(userDetails, loanRequest);
        //sets the new decision into the loan request
        loanRequest.setDecision(decision);

        //this user saves the loan request as a string into it's loan history
        userDetails.setLoanHistory(loanRequest);

        //userDetailsRepository.save(userDetails);


        return decision;
    }


    @Override
    public long calculateCreditScore (int creditModifier,LoanRequest loanRequest) {

        return ((long) (creditModifier / loanRequest.getRequestLoanAmount()) * loanRequest.getRequestLoanPeriod());
    }

    @Override
    public String approveLoan (UserDetails userDetails, LoanRequest loanRequest) {
        String LOAN_APPROVED = "Loan approved";
        String LOAN_NOT_APPROVED = "Loan not approved";
        String LOAN_SUITABLE= "Best suitable loan";
        int minPeriod = Limits.PeriodMin.getValue();
        int minAmount = Limits.AmountMin.getValue();
        int modifier = userDetails.getSegmentation().getValue();

        if (modifier == 0) {
            return LOAN_NOT_APPROVED;
        }
        else {
            long creditScore = calculateCreditScore(modifier, loanRequest);

            if (creditScore >= 1) {
                return LOAN_APPROVED +" for " + String.format("%.2f", (double)loanRequest.getRequestLoanAmount()) +
                        " euros for " + loanRequest.getRequestLoanPeriod() + " months.";
            }
            else{
               Double approvedAmount = checkAmount(minPeriod,modifier );
               if(approvedAmount>=Limits.AmountMin.getValue()){
                   return LOAN_SUITABLE + " is " + String.format("%.2f", approvedAmount) + " euros for " + minPeriod
                           + " months.";
               }
               else{
                   Double approvedPeriod = checkPeriod(minAmount, modifier);
                   return LOAN_SUITABLE + " is " + String.format("%.2f", (double) minAmount)  + " euros for" + approvedPeriod
                           + " months.";
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
