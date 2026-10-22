package app.view;

import app.domain.Appointment;
import app.domain.AppointmentStatus;
import app.domain.Patient;
import app.domain.Professional;
import app.service.helpers.SetAppointmentStatus;
import app.service.inputports.AppointmentUseCase;
import app.service.inputports.PatientUseCase;
import app.service.inputports.ProfessionalUseCase;
import app.utils.FormRuleValidator;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentView {

    // Inyección de dependencias
    private final AppointmentUseCase appointmentUseCase;
    private final PatientUseCase patientUseCase;
    private final ProfessionalUseCase professionalUseCase;

    public AppointmentView(AppointmentUseCase appointmentUseCase, PatientUseCase patientUseCase, ProfessionalUseCase professionalUseCase) {
        this.appointmentUseCase = appointmentUseCase;
        this.patientUseCase = patientUseCase;
        this.professionalUseCase = professionalUseCase;
    }

    public void createAppointment() {
        List<Patient> patients = patientUseCase.getAllPatients();
        List<Professional> professionals = professionalUseCase.getAllProfessionals();

        if (patients.isEmpty()) {
            System.out.println("Primero debe registrar al menos un paciente.");
            return;
        }
        if (professionals.isEmpty()) {
            System.out.println("Primero debe registrar al menos un profesional.");
            return;
        }

        int id = FormRuleValidator.validateInt("Ingrese el id de la cita");

        System.out.println("Pacientes disponibles:");
        for (Patient patient : patients) {
            System.out.println(patient.getId() + ". " + patient.getName() + " " + patient.getLastName());
        }
        int patientId = FormRuleValidator.validateInt("Ingrese el id del paciente");

        System.out.println("Profesionales disponibles:");
        for (Professional professional : professionals) {
            System.out.println(professional.getId() + ". " + professional.getName() + " " + professional.getLastName());
        }
        int professionalId = FormRuleValidator.validateInt("Ingrese el id del profesional");

        LocalDateTime date = FormRuleValidator.validateDateTime("Ingrese la fecha y hora de la cita");
        AppointmentStatus status = SetAppointmentStatus.getAppointmentStatus();

        try {
            Appointment appointment = appointmentUseCase.createAppointment(id, patientId, professionalId, date, status);
            System.out.println("Cita creada correctamente:");
            printAppointment(appointment);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showAppointments() {
        List<Appointment> appointments = appointmentUseCase.getAllAppointments();

        if (appointments.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }

        for (Appointment appointment : appointments) {
            printAppointment(appointment);
            System.out.println("-----");
        }
    }

    private void printAppointment(Appointment appointment) {
        System.out.println(appointment);
        System.out.println("Paciente: " + appointment.getPatient().getName() + " " + appointment.getPatient().getLastName());
        System.out.println("Profesional: " + appointment.getProfessional().getName() + " " + appointment.getProfessional().getLastName());
    }
}