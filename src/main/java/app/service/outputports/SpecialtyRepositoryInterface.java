package app.service.outputports;

import app.domain.Specialty;

import java.util.List;

public interface SpecialtyRepositoryInterface {

    Specialty saveSpecialty(Specialty specialty);

    Specialty selectSpecialtyById(int id);

    List<Specialty> selectAllSpecialties();

    Specialty updateSpecialty(Specialty specialty);

    void deleteSpecialtyById(int id);
}