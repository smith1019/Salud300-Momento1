package domain;

import java.util.Scanner;

public class Prescription {
    public Scanner sc = new Scanner(System.in);

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

    public void create() {
        System.out.println("Ingrese el Id de la prescripción");
        this.id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese los datos del tratamiento");
        this.treatment = new Treatment();
        this.treatment.create();

        System.out.println("Ingrese los datos del medicamento");
        this.medication = new Medication();
        this.medication.create();

        System.out.println("Ingrese la frecuencia (ej: Cada 8 horas)");
        this.frequency = sc.nextLine();

        System.out.println("Ingrese la duración (ej: 7 días)");
        this.duration = sc.nextLine();
    }

    public void select() {
        System.out.println("Id prescripción: " + this.id + "\n" +
                "Frecuencia: " + this.frequency + "\n" +
                "Duración: " + this.duration
        );
        this.treatment.select();
        this.medication.select();
    }
}
