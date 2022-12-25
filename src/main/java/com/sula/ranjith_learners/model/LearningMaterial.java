package com.sula.ranjith_learners.model;

import com.sula.ranjith_learners.model.enums.LearningMaterialType;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "learning_material")
public class LearningMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @Column(name = "learning_material_type")
    private LearningMaterialType learningMaterialType;
    @ManyToOne
    @JoinColumn(name = "uploaded_by", referencedColumnName = "id")
    private Employee uploadedBy;
    private String URL;
    @Column(name = "date_of_uploaded")
    private Date dateOfUploaded;

    public LearningMaterial() {
    }

    public LearningMaterial(int id, String description, LearningMaterialType learningMaterialType, Employee uploadedBy, String URL, Date dateOfUploaded) {
        this.id = id;
        this.description = description;
        this.learningMaterialType = learningMaterialType;
        this.uploadedBy = uploadedBy;
        this.URL = URL;
        this.dateOfUploaded = dateOfUploaded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LearningMaterialType getLearningMaterialType() {
        return learningMaterialType;
    }

    public void setLearningMaterialType(LearningMaterialType learningMaterialType) {
        this.learningMaterialType = learningMaterialType;
    }

    public Employee getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(Employee uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Date getDateOfUploaded() {
        return dateOfUploaded;
    }

    public void setDateOfUploaded(Date dateOfUploaded) {
        this.dateOfUploaded = dateOfUploaded;
    }

    @Override
    public String toString() {
        return "LearningMaterial{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", learningMaterialType=" + learningMaterialType +
                ", uploadedBy=" + uploadedBy +
                ", URL='" + URL + '\'' +
                ", dateOfUploaded=" + dateOfUploaded +
                '}';
    }
}
