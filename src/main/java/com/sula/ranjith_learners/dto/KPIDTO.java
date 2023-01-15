package com.sula.ranjith_learners.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class KPIDTO {

    int id;
    int efficiencyLevel;
    int availabilityLevel;
    int reliabilityLevel;
    int employee;
}
