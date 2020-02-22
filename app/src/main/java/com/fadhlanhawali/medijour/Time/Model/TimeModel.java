package com.fadhlanhawali.medijour.Time.Model;

public class TimeModel {
    private Long medicationTime;
    private Boolean medication;

    public TimeModel(Long medicationTime, Boolean medication) {
        this.medicationTime = medicationTime;
        this.medication = medication;
    }

    public Boolean getMedication() {
        return medication;
    }

    public void setMedication(Boolean medication) {
        this.medication = medication;
    }

    public Long getMedicationTime() {
        return medicationTime;
    }

    public void setMedicationTime(Long medicationTime) {
        this.medicationTime = medicationTime;
    }
}
