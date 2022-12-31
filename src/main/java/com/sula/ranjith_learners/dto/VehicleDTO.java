package com.sula.ranjith_learners.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDTO {

    private int id;
    private String number;
    private String typeAndModel;
    private int branchId;
    private int supplierId;
}
