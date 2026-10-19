package app.domain;

public class VitalSign {

    // Atributes

    private int id;
    private Consultation consultation;
    private double temperature;
    private String pressure;

    // Constructores

    public VitalSign() {

    }

    public VitalSign(int id, Consultation consultation, double temperature, String pressure) {
        this.id = id;
        this.consultation = consultation;
        this.temperature = temperature;
        this.pressure = pressure;
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

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    // Methods

    @Override
    public String toString() {
        return "Id signo vital: " + this.id + "\n" +
                "Temperatura: " + this.temperature + "\n" +
                "Presión: " + this.pressure;
    }
}