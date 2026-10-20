package app.service.inputports;

import app.domain.Specialty;

import java.util.List;

public interface SpecialtyUseCase {

    Specialty createSpecialty(int id, String name);

    Specialty getSpecialtyById(int id);

    List<Specialty> getAllSpecialties();

    Specialty updateSpecialty(int id, String name);

    void deleteSpecialty(int id);
}