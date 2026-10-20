package app.view;

import app.domain.Gender;
import app.domain.Patient;
import app.service.helpers.SetGender;
import app.service.inputports.PatientUseCase;
import app.utils.FormRuleValidator;

import java.time.LocalDate;
import java.util.List;

public class PatientView {

    // Inyección de dependencias
    private final PatientUseCase patientUseCase;

    public PatientView(PatientUseCase patientUseCase) {
        this.patientUseCase = patientUseCase;
    }

    public void createPatient() {
        int id = FormRuleValidator.validateInt("Ingrese el id del paciente");
        String identification = FormRuleValidator.validateString("Ingrese la identificación");
        String name = FormRuleValidator.validateString("Ingrese el nombre");
        String lastName = FormRuleValidator.validateString("Ingrese el apellido");
        Gender gender = SetGender.getGender();
        LocalDate dateOfBirth = FormRuleValidator.validateDate("Ingrese la fecha de nacimiento");
        String phone = FormRuleValidator.validateString("Ingrese el teléfono");

        try {
            Patient patient = patientUseCase.createPatient(id, identification, name, lastName, gender, dateOfBirth, phone);
            System.out.println("Paciente creado correctamente:\n" + patient);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showPatients() {
        List<Patient> patients = patientUseCase.getAllPatients();

        if (patients.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        for (Patient patient : patients) {
            System.out.println(patient);
            System.out.println("-----");
        }
    }
}
