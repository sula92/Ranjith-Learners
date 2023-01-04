package com.sula.ranjith_learners.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicles")
@Builder
public class Vehicle implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String number;
    @Column(name = "type_and_model")
    private String typeAndModel;
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    @NotNull
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;


}
