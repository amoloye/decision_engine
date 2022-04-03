package com.example.decision_engine.controller;

import com.example.decision_engine.entity.LoanRequest;
import com.example.decision_engine.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class LoanController {
    private final LoanService loanService;


    @GetMapping("/decision")
    public ResponseEntity<String> fetchLoanDecision(@Valid @RequestBody LoanRequest loanRequest) throws Exception {
        return new ResponseEntity<>( loanService.makeLoanRequest(loanRequest), HttpStatus.OK);

    }

}
