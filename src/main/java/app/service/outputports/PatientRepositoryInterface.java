package app.service.outputports;

import app.domain.Patient;

import java.util.List;

public interface PatientRepositoryInterface {

    Patient savePatient(Patient patient);

    Patient selectPatientById(int id);

    List<Patient> selectAllPatients();

    Patient updatePatient(Patient patient);

    void deletePatientById(int id);
}