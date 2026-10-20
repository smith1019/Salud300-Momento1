package app.view;

import app.domain.Professional;
import app.domain.Specialty;
import app.service.inputports.ProfessionalUseCase;
import app.service.inputports.SpecialtyUseCase;
import app.utils.FormRuleValidator;

import java.util.List;

public class ProfessionalView {

    // Inyección de dependencias
    private final ProfessionalUseCase professionalUseCase;
    private final SpecialtyUseCase specialtyUseCase;

    public ProfessionalView(ProfessionalUseCase professionalUseCase, SpecialtyUseCase specialtyUseCase) {
        this.professionalUseCase = professionalUseCase;
        this.specialtyUseCase = specialtyUseCase;
    }

    public void createProfessional() {
        List<Specialty> specialties = specialtyUseCase.getAllSpecialties();

        if (specialties.isEmpty()) {
            System.out.println("Primero debe registrar al menos una especialidad.");
            return;
        }

        int id = FormRuleValidator.validateInt("Ingrese el id del profesional");
        String identification = FormRuleValidator.validateString("Ingrese la identificación");
        String name = FormRuleValidator.validateString("Ingrese el nombre");
        String lastName = FormRuleValidator.validateString("Ingrese el apellido");
        String licenseNumber = FormRuleValidator.validateString("Ingrese el número de licencia");
        String email = FormRuleValidator.validateString("Ingrese el correo");

        System.out.println("Especialidades disponibles:");
        for (Specialty specialty : specialties) {
            System.out.println(specialty.getId() + ". " + specialty.getName());
        }
        int specialtyId = FormRuleValidator.validateInt("Ingrese el id de la especialidad");

        try {
            Professional professional = professionalUseCase.createProfessional(id, identification, name, lastName, licenseNumber, email, specialtyId);
            System.out.println("Profesional creado correctamente:\n" + professional);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showProfessionals() {
        List<Professional> professionals = professionalUseCase.getAllProfessionals();

        if (professionals.isEmpty()) {
            System.out.println("No hay profesionales registrados.");
            return;
        }

        for (Professional professional : professionals) {
            System.out.println(professional);
            System.out.println("-----");
        }
    }
}