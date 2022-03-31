package com.example.decision_engine.entity;

public enum DecisionBinary {
    POSITIVE(1),
    NEGATIVE(0);

    private final int value;

    DecisionBinary (final int newValue) {
        value = newValue;
    }
    public LoanDecision getValue (int i) { return value; }





}
