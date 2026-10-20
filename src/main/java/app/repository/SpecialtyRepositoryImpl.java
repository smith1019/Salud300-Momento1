package app.repository;

import app.domain.Specialty;
import app.service.outputports.SpecialtyRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

public class SpecialtyRepositoryImpl implements SpecialtyRepositoryInterface {

    private final List<Specialty> specialtyList = new ArrayList<>();

    @Override
    public Specialty saveSpecialty(Specialty specialty) {
        specialtyList.add(specialty);
        return specialty;
    }

    @Override
    public Specialty selectSpecialtyById(int id) {
        for (Specialty item : specialtyList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Specialty> selectAllSpecialties() {
        return new ArrayList<>(specialtyList);
    }

    @Override
    public Specialty updateSpecialty(Specialty specialty) {
        for (int i = 0; i < specialtyList.size(); i++) {
            if (specialtyList.get(i).getId() == specialty.getId()) {
                specialtyList.set(i, specialty);
                return specialty;
            }
        }
        return null;
    }

    @Override
    public void deleteSpecialtyById(int id) {
        specialtyList.removeIf(item -> item.getId() == id);
    }
}