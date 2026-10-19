package app.service.helpers;

import app.domain.AppointmentStatus;
import app.utils.FormRuleValidator;

public class SetAppointmentStatus {

    public static AppointmentStatus getAppointmentStatus() {

        while (true) {
            int option = FormRuleValidator.validateInt("""
                    Seleccione el estado de la cita:
                    1. Agendada
                    2. Completada
                    3. Cancelada
                    """);

            switch (option) {
                case 1:
                    return AppointmentStatus.SCHEDULED;
                case 2:
                    return AppointmentStatus.COMPLETED;
                case 3:
                    return AppointmentStatus.CANCELLED;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}