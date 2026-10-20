package app.service;

import app.domain.Gender;
import app.domain.Patient;
import app.service.inputports.PatientUseCase;
import app.service.outputports.PatientRepositoryInterface;

import java.time.LocalDate;
import java.util.List;

public class PatientServiceImpl implements PatientUseCase {

    // Inyección de dependencias
    private final PatientRepositoryInterface patientRepository;

    public PatientServiceImpl(PatientRepositoryInterface patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient createPatient(int id, String identification, String name, String lastName, Gender gender, LocalDate dateOfBirth, String phone) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor que cero");
        }
        if (patientRepository.selectPatientById(id) != null) {
            throw new IllegalArgumentException("Ya existe un paciente con el id " + id);
        }
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura");
        }
        Patient patient = new Patient(id, identification, name, lastName, gender, dateOfBirth, phone);
        return patientRepository.savePatient(patient);
    }

    @Override
    public Patient getPatientById(int id) {
        Patient patient = patientRepository.selectPatientById(id);
        if (patient == null) {
            throw new IllegalArgumentException("No existe un paciente con el id " + id);
        }
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.selectAllPatients();
    }

    @Override
    public Patient updatePatient(int id, String identification, String name, String lastName, Gender gender, LocalDate dateOfBirth, String phone) {
        Patient patient = getPatientById(id);
        patient.setIdentification(identification);
        patient.setName(name);
        patient.setLastName(lastName);
        patient.setGender(gender);
        patient.setDateOfBirth(dateOfBirth);
        patient.setPhone(phone);
        return patientRepository.updatePatient(patient);
    }

    @Override
    public void deletePatient(int id) {
        getPatientById(id);
        patientRepository.deletePatientById(id);
    }
}