package app.domain;

import java.time.LocalDate;

public class Treatment {

    // Atributes

    private int id;
    private Diagnosis diagnosis;
    private LocalDate initialDate;
    private LocalDate endDate;

    // Constructores

    public Treatment() {

    }

    public Treatment(int id, Diagnosis diagnosis, LocalDate initialDate, LocalDate endDate) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.initialDate = initialDate;
        this.endDate = endDate;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Methods

    @Override
    public String toString() {
        return "Id tratamiento: " + this.id + "\n" +
                "Fecha inicial: " + this.initialDate + "\n" +
                "Fecha final: " + this.endDate;
    }
}