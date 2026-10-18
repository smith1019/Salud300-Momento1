package domain;

import java.util.Scanner;

public class PatientAllergy {
    public Scanner sc = new Scanner(System.in);

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

    public void create() {
        System.out.println("Ingrese los datos del paciente");
        this.patient = new Patient();
        this.patient.create();

        System.out.println("Ingrese los datos de la alergia");
        this.allergy = new Allergy();
        this.allergy.create();

        System.out.println("Ingrese la reacción presentada");
        this.reaction = sc.nextLine();
    }

    public void select() {
        this.patient.select();
        this.allergy.select();
        System.out.println("Reacción: " + this.reaction);
    }
}
