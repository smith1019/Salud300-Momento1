package app.service.inputports;

import app.domain.Medication;

import java.util.List;

public interface MedicationUseCase {

    Medication createMedication(int id, String name, String dosis, String manufacturer);

    Medication getMedicationById(int id);

    List<Medication> getAllMedications();

    Medication updateMedication(int id, String name, String dosis, String manufacturer);

    void deleteMedication(int id);
}