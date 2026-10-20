package app.service;

import app.domain.Professional;
import app.domain.Specialty;
import app.service.inputports.ProfessionalUseCase;
import app.service.outputports.ProfessionalRepositoryInterface;
import app.service.outputports.SpecialtyRepositoryInterface;

import java.util.List;

public class ProfessionalServiceImpl implements ProfessionalUseCase {

    // Inyección de dependencias
    private final ProfessionalRepositoryInterface professionalRepository;
    private final SpecialtyRepositoryInterface specialtyRepository;

    public ProfessionalServiceImpl(ProfessionalRepositoryInterface professionalRepository, SpecialtyRepositoryInterface specialtyRepository) {
        this.professionalRepository = professionalRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Professional createProfessional(int id, String identification, String name, String lastName, String licenseNumber, String email, int specialtyId) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor que cero");
        }
        if (professionalRepository.selectProfessionalById(id) != null) {
            throw new IllegalArgumentException("Ya existe un profesional con el id " + id);
        }
        Specialty specialty = findSpecialty(specialtyId);
        Professional professional = new Professional(id, identification, name, lastName, licenseNumber, email, specialty);
        return professionalRepository.saveProfessional(professional);
    }

    @Override
    public Professional getProfessionalById(int id) {
        Professional professional = professionalRepository.selectProfessionalById(id);
        if (professional == null) {
            throw new IllegalArgumentException("No existe un profesional con el id " + id);
        }
        return professional;
    }

    @Override
    public List<Professional> getAllProfessionals() {
        return professionalRepository.selectAllProfessionals();
    }

    @Override
    public Professional updateProfessional(int id, String identification, String name, String lastName, String licenseNumber, String email, int specialtyId) {
        Professional professional = getProfessionalById(id);
        Specialty specialty = findSpecialty(specialtyId);
        professional.setIdentification(identification);
        professional.setName(name);
        professional.setLastName(lastName);
        professional.setLicenseNumber(licenseNumber);
        professional.setEmail(email);
        professional.setSpecialty(specialty);
        return professionalRepository.updateProfessional(professional);
    }

    @Override
    public void deleteProfessional(int id) {
        getProfessionalById(id);
        professionalRepository.deleteProfessionalById(id);
    }

    // Helpers

    private Specialty findSpecialty(int specialtyId) {
        Specialty specialty = specialtyRepository.selectSpecialtyById(specialtyId);
        if (specialty == null) {
            throw new IllegalArgumentException("No existe una especialidad con el id " + specialtyId);
        }
        return specialty;
    }
}