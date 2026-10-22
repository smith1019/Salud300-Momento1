package app.repository;

import app.domain.Appointment;
import app.service.outputports.AppointmentRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRepositoryImpl implements AppointmentRepositoryInterface {

    private final List<Appointment> appointmentList = new ArrayList<>();

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        appointmentList.add(appointment);
        return appointment;
    }

    @Override
    public Appointment selectAppointmentById(int id) {
        for (Appointment item : appointmentList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Appointment> selectAllAppointments() {
        return new ArrayList<>(appointmentList);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getId() == appointment.getId()) {
                appointmentList.set(i, appointment);
                return appointment;
            }
        }
        return null;
    }

    @Override
    public void deleteAppointmentById(int id) {
        appointmentList.removeIf(item -> item.getId() == id);
    }
}