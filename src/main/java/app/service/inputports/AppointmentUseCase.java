package app.service.inputports;

import app.domain.Appointment;
import app.domain.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentUseCase {

    Appointment createAppointment(int id, int patientId, int professionalId, LocalDateTime date, AppointmentStatus status);

    Appointment getAppointmentById(int id);

    List<Appointment> getAllAppointments();

    Appointment updateAppointment(int id, int patientId, int professionalId, LocalDateTime date, AppointmentStatus status);

    void deleteAppointment(int id);
}