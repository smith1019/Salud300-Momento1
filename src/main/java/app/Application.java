package app;

import app.domain.AppointmentStatus;
import app.domain.Gender;
import app.service.helpers.SetAppointmentStatus;
import app.service.helpers.SetGender;
import app.utils.FormRuleValidator;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {
        int id = FormRuleValidator.validateInt("Ingrese un id");
        double temperature = FormRuleValidator.validateDouble("Ingrese la temperatura");
        String name = FormRuleValidator.validateString("Ingrese un nombre");
        LocalDate birth = FormRuleValidator.validateDate("Ingrese la fecha de nacimiento");
        LocalDateTime appointmentDate = FormRuleValidator.validateDateTime("Ingrese la fecha y hora de la cita");
        Gender gender = SetGender.getGender();
        AppointmentStatus status = SetAppointmentStatus.getAppointmentStatus();

        System.out.println("---- Resultado ----");
        System.out.println("Id: " + id);
        System.out.println("Temperatura: " + temperature);
        System.out.println("Nombre: " + name);
        System.out.println("Nacimiento: " + birth);
        System.out.println("Cita: " + appointmentDate);
        System.out.println("Género: " + gender.getValue());
        System.out.println("Estado: " + status.getValue());
    }
}