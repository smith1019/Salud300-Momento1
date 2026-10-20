package app.view;

import app.domain.Specialty;
import app.service.inputports.SpecialtyUseCase;
import app.utils.FormRuleValidator;

import java.util.List;

public class SpecialtyView {

    // Inyección de dependencias
    private final SpecialtyUseCase specialtyUseCase;

    public SpecialtyView(SpecialtyUseCase specialtyUseCase) {
        this.specialtyUseCase = specialtyUseCase;
    }

    public void createSpecialty() {
        int id = FormRuleValidator.validateInt("Ingrese el id de la especialidad");
        String name = FormRuleValidator.validateString("Ingrese el nombre de la especialidad");

        try {
            Specialty specialty = specialtyUseCase.createSpecialty(id, name);
            System.out.println("Especialidad creada correctamente:\n" + specialty);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showSpecialties() {
        List<Specialty> specialties = specialtyUseCase.getAllSpecialties();

        if (specialties.isEmpty()) {
            System.out.println("No hay especialidades registradas.");
            return;
        }

        for (Specialty specialty : specialties) {
            System.out.println(specialty);
            System.out.println("-----");
        }
    }
}