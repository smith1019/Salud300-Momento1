package app.service;

import app.domain.Specialty;
import app.service.inputports.SpecialtyUseCase;
import app.service.outputports.SpecialtyRepositoryInterface;

import java.util.List;

public class SpecialtyServiceImpl implements SpecialtyUseCase {

    // Inyección de dependencias
    private final SpecialtyRepositoryInterface specialtyRepository;

    public SpecialtyServiceImpl(SpecialtyRepositoryInterface specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Specialty createSpecialty(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor que cero");
        }
        if (specialtyRepository.selectSpecialtyById(id) != null) {
            throw new IllegalArgumentException("Ya existe una especialidad con el id " + id);
        }
        Specialty specialty = new Specialty(id, name);
        return specialtyRepository.saveSpecialty(specialty);
    }

    @Override
    public Specialty getSpecialtyById(int id) {
        Specialty specialty = specialtyRepository.selectSpecialtyById(id);
        if (specialty == null) {
            throw new IllegalArgumentException("No existe una especialidad con el id " + id);
        }
        return specialty;
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.selectAllSpecialties();
    }

    @Override
    public Specialty updateSpecialty(int id, String name) {
        Specialty specialty = getSpecialtyById(id);
        specialty.setName(name);
        return specialtyRepository.updateSpecialty(specialty);
    }

    @Override
    public void deleteSpecialty(int id) {
        getSpecialtyById(id);
        specialtyRepository.deleteSpecialtyById(id);
    }
}