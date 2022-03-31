package com.example.decision_engine.repository;

import com.example.decision_engine.entity.LoanDecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDecisionRepository extends JpaRepository<LoanDecision,Integer> {
    LoanDecision findByPersonalCode(String personalCode);


}
