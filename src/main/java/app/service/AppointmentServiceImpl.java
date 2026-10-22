package app.service;

import app.domain.Appointment;
import app.domain.AppointmentStatus;
import app.domain.Patient;
import app.domain.Professional;
import app.service.inputports.AppointmentUseCase;
import app.service.outputports.AppointmentRepositoryInterface;
import app.service.outputports.PatientRepositoryInterface;
import app.service.outputports.ProfessionalRepositoryInterface;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentServiceImpl implements AppointmentUseCase {

    // Inyección de dependencias
    private final AppointmentRepositoryInterface appointmentRepository;
    private final PatientRepositoryInterface patientRepository;
    private final ProfessionalRepositoryInterface professionalRepository;

    public AppointmentServiceImpl(AppointmentRepositoryInterface appointmentRepository,
                                  PatientRepositoryInterface patientRepository,
                                  ProfessionalRepositoryInterface professionalRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.professionalRepository = professionalRepository;
    }

    @Override
    public Appointment createAppointment(int id, int patientId, int professionalId, LocalDateTime date, AppointmentStatus status) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor que cero");
        }
        if (appointmentRepository.selectAppointmentById(id) != null) {
            throw new IllegalArgumentException("Ya existe una cita con el id " + id);
        }
        Patient patient = findPatient(patientId);
        Professional professional = findProfessional(professionalId);
        checkProfessionalIsFree(professionalId, date, -1);

        Appointment appointment = new Appointment(id, patient, professional, date, status);
        return appointmentRepository.saveAppointment(appointment);
    }

    @Override
    public Appointment getAppointmentById(int id) {
        Appointment appointment = appointmentRepository.selectAppointmentById(id);
        if (appointment == null) {
            throw new IllegalArgumentException("No existe una cita con el id " + id);
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.selectAllAppointments();
    }

    @Override
    public Appointment updateAppointment(int id, int patientId, int professionalId, LocalDateTime date, AppointmentStatus status) {
        Appointment appointment = getAppointmentById(id);
        Patient patient = findPatient(patientId);
        Professional professional = findProfessional(professionalId);
        checkProfessionalIsFree(professionalId, date, id);

        appointment.setPatient(patient);
        appointment.setProfessional(professional);
        appointment.setDate(date);
        appointment.setStatus(status);
        return appointmentRepository.updateAppointment(appointment);
    }

    @Override
    public void deleteAppointment(int id) {
        getAppointmentById(id);
        appointmentRepository.deleteAppointmentById(id);
    }

    // Helpers

    private Patient findPatient(int patientId) {
        Patient patient = patientRepository.selectPatientById(patientId);
        if (patient == null) {
            throw new IllegalArgumentException("No existe un paciente con el id " + patientId);
        }
        return patient;
    }

    private Professional findProfessional(int professionalId) {
        Professional professional = professionalRepository.selectProfessionalById(professionalId);
        if (professional == null) {
            throw new IllegalArgumentException("No existe un profesional con el id " + professionalId);
        }
        return professional;
    }

    // ignoreId sirve para no compararse con la propia cita al actualizar (al crear se pasa -1)
    private void checkProfessionalIsFree(int professionalId, LocalDateTime date, int ignoreId) {
        for (Appointment existing : appointmentRepository.selectAllAppointments()) {
            boolean sameProfessional = existing.getProfessional().getId() == professionalId;
            boolean sameDate = existing.getDate().equals(date);
            boolean otherAppointment = existing.getId() != ignoreId;

            if (sameProfessional && sameDate && otherAppointment) {
                throw new IllegalArgumentException("El profesional ya tiene una cita en esa fecha y hora");
            }
        }
    }
}