package app.domain;

import java.time.LocalDate;

public class MedicalRecord {

    // Atributes

    private int id;
    private Patient patient;
    private LocalDate creationDate;

    // Constructores

    public MedicalRecord() {

    }

    public MedicalRecord(int id, Patient patient, LocalDate creationDate) {
        this.id = id;
        this.patient = patient;
        this.creationDate = creationDate;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    // Methods

    @Override
    public String toString() {
        return "Id historia clínica: " + this.id + "\n" +
                "Fecha de creación: " + this.creationDate;
    }
}