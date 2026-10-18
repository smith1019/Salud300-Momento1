package domain;

import java.util.Scanner;

public class VitalSign {
    public Scanner sc = new Scanner(System.in);

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

    public void create() {
        System.out.println("Ingrese el Id del signo vital");
        this.id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese los datos de la consulta");
        this.consultation = new Consultation();
        this.consultation.create();

        System.out.println("Ingrese la temperatura");
        this.temperature = sc.nextDouble();
        sc.nextLine();

        System.out.println("Ingrese la presión arterial (ej: 120/80)");
        this.pressure = sc.nextLine();
    }

    public void select() {
        System.out.println("Id signo vital: " + this.id + "\n" +
                "Temperatura: " + this.temperature + "\n" +
                "Presión: " + this.pressure
        );
        this.consultation.select();
    }
}
