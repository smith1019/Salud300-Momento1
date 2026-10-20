package app.service.outputports;

import app.domain.Professional;

import java.util.List;

public interface ProfessionalRepositoryInterface {

    Professional saveProfessional(Professional professional);

    Professional selectProfessionalById(int id);

    List<Professional> selectAllProfessionals();

    Professional updateProfessional(Professional professional);

    void deleteProfessionalById(int id);
}