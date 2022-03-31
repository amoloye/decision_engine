package com.example.decision_engine.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userDetailsId;

    @NotEmpty
    private String personalCode;

    @OneToOne
    @JoinColumn(name="segmentationId")
    private Segmentation segmentation;


}
