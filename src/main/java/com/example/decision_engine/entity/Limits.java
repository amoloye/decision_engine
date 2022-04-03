package com.example.decision_engine.entity;

public enum Limits {
    AmountMax(10000),
    AmountMin(2000),
    PeriodMax(60),
    PeriodMin(12);
    private final int value;

    Limits (int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }

}
