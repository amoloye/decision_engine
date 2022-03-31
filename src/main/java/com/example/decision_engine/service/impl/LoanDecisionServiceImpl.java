package com.example.decision_engine.service.impl;

import com.example.decision_engine.entity.LoanDecision;
import com.example.decision_engine.entity.UserRequest;
import com.example.decision_engine.repository.LoanDecisionRepository;
import com.example.decision_engine.service.LoanDecisionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoanDecisionServiceImpl implements LoanDecisionService {

    private static final String LOANNOTAPPROVED="User cannot get loan at this time";
    private final LoanDecisionRepository loanDecisionRepository;


    @Override
    public LoanDecision createLoanDecision (LoanDecision loanDecision, UserRequest userRequest) throws Exception {
        LoanDecision loanDB = null;
        //calculate credit Score
        int creditScore = (int) ((loanDecision.getUserDetails().getSegmentation().getCreditModifier()
                        / userRequest.getRequestLoanAmount())
                        * userRequest.getRequestLoanPeriod());

        if(creditScore==0){
           loanDB=new LoanDecision(loanDecision.getUserDetails().getPersonalCode(),0,
                   loanDecision.getDecisionBinary().getValue(0),0,0,0,0,0);
            //throw new Exception(LOANNOTAPPROVED);
        }
        else {
            System.out.println("Look for possible best offer");

        }
       return loanDecisionRepository.save(loanDB);

    }

    @Override
    public LoanDecision fetchLoanDecisionByPersonalCode (String personalCode) {
        return loanDecisionRepository.findByPersonalCode(personalCode);
    }
}
