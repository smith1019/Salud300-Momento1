package app.repository;

import app.domain.Patient;
import app.service.outputports.PatientRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

public class PatientRepositoryImpl implements PatientRepositoryInterface {

    private final List<Patient> patientList = new ArrayList<>();

    @Override
    public Patient savePatient(Patient patient) {
        patientList.add(patient);
        return patient;
    }

    @Override
    public Patient selectPatientById(int id) {
        for (Patient item : patientList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Patient> selectAllPatients() {
        return new ArrayList<>(patientList);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getId() == patient.getId()) {
                patientList.set(i, patient);
                return patient;
            }
        }
        return null;
    }

    @Override
    public void deletePatientById(int id) {
        patientList.removeIf(item -> item.getId() == id);
    }
}