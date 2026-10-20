package app.service.inputports;

import app.domain.Allergy;

import java.util.List;

public interface AllergyUseCase {

    Allergy createAllergy(int id, String name);

    Allergy getAllergyById(int id);

    List<Allergy> getAllAllergies();

    Allergy updateAllergy(int id, String name);

    void deleteAllergy(int id);
}