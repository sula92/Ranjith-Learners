package com.sula.ranjith_learners.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vehicles")
public class Vehicle implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String number;
    @Column(name = "type_and_model")
    private String typeAndModel;
    @OneToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    @NotNull
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;


    public Vehicle() {
    }


}
