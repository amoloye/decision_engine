package com.example.decision_engine.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Segmentation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int segmentationId;

    @NotBlank
    private String segmentationName;

    @NotEmpty
    private long creditModifier;




}
