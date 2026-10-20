package app.repository;

import app.domain.Professional;
import app.service.outputports.ProfessionalRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

public class ProfessionalRepositoryImpl implements ProfessionalRepositoryInterface {

    private final List<Professional> professionalList = new ArrayList<>();

    @Override
    public Professional saveProfessional(Professional professional) {
        professionalList.add(professional);
        return professional;
    }

    @Override
    public Professional selectProfessionalById(int id) {
        for (Professional item : professionalList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Professional> selectAllProfessionals() {
        return new ArrayList<>(professionalList);
    }

    @Override
    public Professional updateProfessional(Professional professional) {
        for (int i = 0; i < professionalList.size(); i++) {
            if (professionalList.get(i).getId() == professional.getId()) {
                professionalList.set(i, professional);
                return professional;
            }
        }
        return null;
    }

    @Override
    public void deleteProfessionalById(int id) {
        professionalList.removeIf(item -> item.getId() == id);
    }
}