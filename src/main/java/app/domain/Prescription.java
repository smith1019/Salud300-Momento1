package app.domain;

public class Prescription {

    // Atributes

    private int id;
    private Treatment treatment;
    private Medication medication;
    private String frequency;
    private String duration;

    // Constructores

    public Prescription() {

    }

    public Prescription(int id, Treatment treatment, Medication medication, String frequency, String duration) {
        this.id = id;
        this.treatment = treatment;
        this.medication = medication;
        this.frequency = frequency;
        this.duration = duration;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    // Methods

    @Override
    public String toString() {
        return "Id prescripción: " + this.id + "\n" +
                "Frecuencia: " + this.frequency + "\n" +
                "Duración: " + this.duration;
    }

}

