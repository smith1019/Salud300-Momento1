package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Consultation {
    public Scanner sc = new Scanner(System.in);

    // Atributes

    private int id;
    private Appointment appointment;
    private String notes;
    private LocalDateTime date;

    // Constructores

    public Consultation() {

    }

    public Consultation(int id, Appointment appointment, String notes, LocalDateTime date) {
        this.id = id;
        this.appointment = appointment;
        this.notes = notes;
        this.date = date;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    // Methods

    public void create() {
        System.out.println("Ingrese el Id de la consulta");
        this.id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese los datos de la cita");
        this.appointment = new Appointment();
        this.appointment.create();

        System.out.println("Ingrese las notas de la consulta");
        this.notes = sc.nextLine();

        System.out.println("Ingrese la fecha y hora de la consulta (yyyy-MM-dd HH:mm)");
        String date = sc.nextLine();
        this.date = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public void select() {
        System.out.println("Id consulta: " + this.id + "\n" +
                "Notas: " + this.notes + "\n" +
                "Fecha: " + this.date
        );
        this.appointment.select();
    }
}
