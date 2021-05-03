package com.sula.ranjith_learners.model.pk;

import com.sula.ranjith_learners.model.Exam;
import com.sula.ranjith_learners.model.Student;
import com.sula.ranjith_learners.model.SuperEntity;

import javax.persistence.*;
import java.util.List;

@Embeddable
public class StudentExamPk implements SuperEntity {

    @Column(name = "exam_id")
    private String exam_id;
    @Column(name = "student_id")
    private long student_id;

    public StudentExamPk() {
    }

    public StudentExamPk(String exam_id, long student_id) {
        this.exam_id = exam_id;
        this.student_id = student_id;
    }

    public String getExam_id() {
        return exam_id;
    }

    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "StudentExamPk{" +
                "exam_id='" + exam_id + '\'' +
                ", student_id=" + student_id +
                '}';
    }
}
