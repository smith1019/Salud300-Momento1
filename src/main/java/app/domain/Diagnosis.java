package app.domain;

public class Diagnosis {

    // Atributes

    private int id;
    private Consultation consultation;
    private String diagnosisCode;

    // Constructores

    public Diagnosis() {

    }

    public Diagnosis(int id, Consultation consultation, String diagnosisCode) {
        this.id = id;
        this.consultation = consultation;
        this.diagnosisCode = diagnosisCode;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    // Methods

    @Override
    public String toString() {
        return "Id diagnóstico: " + this.id + "\n" +
                "Código: " + this.diagnosisCode;
    }
}