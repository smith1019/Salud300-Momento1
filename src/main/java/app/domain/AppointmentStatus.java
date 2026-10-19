package app.domain;

public enum AppointmentStatus {
    SCHEDULED("Agendada"),
    COMPLETED("Completada"),
    CANCELLED("Cancelada");

    private final String value;

    AppointmentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}