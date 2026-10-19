package app.domain;

public class PatientAllergy {

    // Atributes

    private Patient patient;
    private Allergy allergy;
    private String reaction;

    // Constructores

    public PatientAllergy() {

    }

    public PatientAllergy(Patient patient, Allergy allergy, String reaction) {
        this.patient = patient;
        this.allergy = allergy;
        this.reaction = reaction;
    }

    // Getters and setters

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    // Methods

    @Override
    public String toString() {
        return "Reacción: " + this.reaction;
    }
}