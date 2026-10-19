package app.domain;

import java.time.LocalDateTime;

public class Appointment {

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

    @Override
    public String toString() {
        return "Id cita: " + this.id + "\n" +
                "Fecha: " + this.date + "\n" +
                "Estado: " + this.status;
    }
}