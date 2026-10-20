package app.service.inputports;

import app.domain.Gender;
import app.domain.Patient;

import java.time.LocalDate;
import java.util.List;

public interface PatientUseCase {

    Patient createPatient(int id, String identification, String name, String lastName, Gender gender, LocalDate dateOfBirth, String phone);

    Patient getPatientById(int id);

    List<Patient> getAllPatients();

    Patient updatePatient(int id, String identification, String name, String lastName, Gender gender, LocalDate dateOfBirth, String phone);

    void deletePatient(int id);
}