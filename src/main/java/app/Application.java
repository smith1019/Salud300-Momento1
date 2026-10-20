package app;

import app.repository.PatientRepositoryImpl;
import app.repository.ProfessionalRepositoryImpl;
import app.repository.SpecialtyRepositoryImpl;
import app.service.PatientServiceImpl;
import app.service.ProfessionalServiceImpl;
import app.service.SpecialtyServiceImpl;
import app.view.PatientView;
import app.view.ProfessionalView;
import app.view.SpecialtyView;

public class Application {

    public static void main(String[] args) {
        // Repositorios
        SpecialtyRepositoryImpl specialtyRepository = new SpecialtyRepositoryImpl();
        ProfessionalRepositoryImpl professionalRepository = new ProfessionalRepositoryImpl();
        PatientRepositoryImpl patientRepository = new PatientRepositoryImpl();

        // Servicios
        SpecialtyServiceImpl specialtyService = new SpecialtyServiceImpl(specialtyRepository);
        ProfessionalServiceImpl professionalService = new ProfessionalServiceImpl(professionalRepository, specialtyRepository);
        PatientServiceImpl patientService = new PatientServiceImpl(patientRepository);

        // Vistas
        SpecialtyView specialtyView = new SpecialtyView(specialtyService);
        ProfessionalView professionalView = new ProfessionalView(professionalService, specialtyService);
        PatientView patientView = new PatientView(patientService);

        // Prueba temporal (el menú real llega en el siguiente bloque)
        specialtyView.createSpecialty();
        professionalView.createProfessional();
        patientView.createPatient();

        System.out.println("===== LISTADOS =====");
        specialtyView.showSpecialties();
        professionalView.showProfessionals();
        patientView.showPatients();
    }
}