package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Appointment {
    public Scanner sc = new Scanner(System.in);

    // Atributes

    private int id;
    private Patient patient;
    private Professional professional;
    private LocalDateTime date;
    private AppointmentStatus status;

    // Constructores

    public Appointment() {

    }

    public Appointment(int id, Patient patient, Professional professional, LocalDateTime date, AppointmentStatus status) {
        this.id = id;
        this.patient = patient;
        this.professional = professional;
        this.date = date;
        this.status = status;
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

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    // Methods

    public void create() {
        System.out.println("Ingrese el Id de la cita");
        this.id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese los datos del paciente");
        this.patient = new Patient();
        this.patient.create();

        System.out.println("Ingrese los datos del profesional");
        this.professional = new Professional();
        this.professional.create();

        System.out.println("Ingrese la fecha y hora de la cita (yyyy-MM-dd HH:mm)");
        String date = sc.nextLine();
        this.date = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        System.out.println("Ingrese el estado: 1. Agendada 2. Completada 3. Cancelada");
        int option = sc.nextInt();
        sc.nextLine();
        this.status = defineStatus(option);
    }

    public void select() {
        System.out.println("Id cita: " + this.id + "\n" +
                "Fecha: " + this.date + "\n" +
                "Estado: " + this.status
        );
        this.patient.select();
        this.professional.select();
    }

    // Helpers

    private AppointmentStatus defineStatus(int option) {
        switch (option) {
            case 1:
                return AppointmentStatus.SCHEDULED;
            case 2:
                return AppointmentStatus.COMPLETED;
            default:
                return AppointmentStatus.CANCELLED;
        }
    }
}
