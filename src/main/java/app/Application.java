package app;

import app.domain.AppointmentStatus;
import app.domain.Gender;
import app.domain.Patient;
import app.domain.Professional;
import app.domain.Specialty;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        Patient patient = new Patient(1, "123", "Ana", "Ruiz", Gender.FEMALE, LocalDate.of(1990, 5, 1), "300");
        System.out.println(patient);
        System.out.println("Género legible: " + patient.getGender().getValue());
        System.out.println("Estado legible: " + AppointmentStatus.CANCELLED.getValue());

        Professional professional = new Professional(2, "456", "Luis", "Mora", "L-9", "luis@correo.com", new Specialty(1, "Cardiología"));
        System.out.println(professional);
        System.out.println("Especialidad: " + professional.getSpecialty().getName());
    }
}