package app.service.outputports;

import app.domain.Medication;

import java.util.List;

public interface MedicationRepositoryInterface {

    Medication saveMedication(Medication medication);

    Medication selectMedicationById(int id);

    List<Medication> selectAllMedications();

    Medication updateMedication(Medication medication);

    void deleteMedicationById(int id);
}