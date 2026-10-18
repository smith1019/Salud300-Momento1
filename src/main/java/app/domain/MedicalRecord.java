package domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MedicalRecord {
    public Scanner sc = new Scanner(System.in);

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

    public void create() {
        System.out.println("Ingrese el Id de la historia clínica");
        this.id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese los datos del paciente");
        this.patient = new Patient();
        this.patient.create();

        System.out.println("Ingrese la fecha de creación (yyyy-MM-dd)");
        String date = sc.nextLine();
        this.creationDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void select() {
        System.out.println("Id historia clínica: " + this.id + "\n" +
                "Fecha de creación: " + this.creationDate
        );
        this.patient.select();
    }
}
