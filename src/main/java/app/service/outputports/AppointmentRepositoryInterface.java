package app.service.outputports;

import app.domain.Appointment;

import java.util.List;

public interface AppointmentRepositoryInterface {

    Appointment saveAppointment(Appointment appointment);

    Appointment selectAppointmentById(int id);

    List<Appointment> selectAllAppointments();

    Appointment updateAppointment(Appointment appointment);

    void deleteAppointmentById(int id);
}