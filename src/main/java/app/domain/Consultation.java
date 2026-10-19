package app.domain;

import java.time.LocalDateTime;

public class Consultation {

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

    @Override
    public String toString() {
        return "Id consulta: " + this.id + "\n" +
                "Notas: " + this.notes + "\n" +
                "Fecha: " + this.date;
    }
}