package app.service.outputports;

import app.domain.Allergy;

import java.util.List;

public interface AllergyRepositoryInterface {

    Allergy saveAllergy(Allergy allergy);

    Allergy selectAllergyById(int id);

    List<Allergy> selectAllAllergies();

    Allergy updateAllergy(Allergy allergy);

    void deleteAllergyById(int id);
}