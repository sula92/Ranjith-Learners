package com.sula.ranjith_learners.model.pk;

import com.sula.ranjith_learners.model.Student;
import com.sula.ranjith_learners.model.SuperEntity;
import com.sula.ranjith_learners.model.Trial;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Embeddable
public class StudentTrialPk implements SuperEntity {

    @Column(name = "trial_id")
   private String trial_id;
    @Column(name = "student_id")
   private long student_id;

    public StudentTrialPk() {
    }

    public StudentTrialPk(String trial_id, long student_id) {
        this.trial_id = trial_id;
        this.student_id = student_id;
    }

    public String getTrial_id() {
        return trial_id;
    }

    public void setTrial_id(String trial_id) {
        this.trial_id = trial_id;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "StudentTrialPk{" +
                "trial_id='" + trial_id + '\'' +
                ", student_id=" + student_id +
                '}';
    }
}
