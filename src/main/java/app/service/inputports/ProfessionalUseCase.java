package app.service.inputports;

import app.domain.Professional;

import java.util.List;

public interface ProfessionalUseCase {

    Professional createProfessional(int id, String identification, String name, String lastName, String licenseNumber, String email, int specialtyId);

    Professional getProfessionalById(int id);

    List<Professional> getAllProfessionals();

    Professional updateProfessional(int id, String identification, String name, String lastName, String licenseNumber, String email, int specialtyId);

    void deleteProfessional(int id);
}