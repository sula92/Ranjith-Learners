package com.sula.ranjith_learners.model.pk;


import com.sula.ranjith_learners.model.SuperEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class EmployeeSalaryPk implements SuperEntity {

    @Column(name = "employee_id")
    private long employee_id;
    @Column(name = "date_of_paid")
    @Temporal(TemporalType.DATE)
    private Date date;


}
