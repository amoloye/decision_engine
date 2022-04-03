package com.example.decision_engine.entity;


public enum Segmentation {
    DEBT(0),
    SEG_ONE(100),
    SEG_TWO(300),
    SEG_THREE(1000);


    private final int value;

    Segmentation (int value) {
        this.value = value;
    }
    public int getValue () { return value; }
}
