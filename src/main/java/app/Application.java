package app;

import app.repository.AppointmentRepositoryImpl;
import app.repository.PatientRepositoryImpl;
import app.repository.ProfessionalRepositoryImpl;
import app.repository.SpecialtyRepositoryImpl;
import app.service.AppointmentServiceImpl;
import app.service.PatientServiceImpl;
import app.service.ProfessionalServiceImpl;
import app.service.SpecialtyServiceImpl;
import app.userinterface.AppUserInterface;
import app.view.AppointmentView;
import app.view.PatientView;
import app.view.ProfessionalView;
import app.view.SpecialtyView;

public class Application {

    public static void main(String[] args) {
        // Repositorios
        SpecialtyRepositoryImpl specialtyRepository = new SpecialtyRepositoryImpl();
        ProfessionalRepositoryImpl professionalRepository = new ProfessionalRepositoryImpl();
        PatientRepositoryImpl patientRepository = new PatientRepositoryImpl();
        AppointmentRepositoryImpl appointmentRepository = new AppointmentRepositoryImpl();

        // Servicios
        SpecialtyServiceImpl specialtyService = new SpecialtyServiceImpl(specialtyRepository);
        ProfessionalServiceImpl professionalService = new ProfessionalServiceImpl(professionalRepository, specialtyRepository);
        PatientServiceImpl patientService = new PatientServiceImpl(patientRepository);
        AppointmentServiceImpl appointmentService = new AppointmentServiceImpl(appointmentRepository, patientRepository, professionalRepository);

        // Vistas
        SpecialtyView specialtyView = new SpecialtyView(specialtyService);
        ProfessionalView professionalView = new ProfessionalView(professionalService, specialtyService);
        PatientView patientView = new PatientView(patientService);
        AppointmentView appointmentView = new AppointmentView(appointmentService, patientService, professionalService);

        // Menú principal
        AppUserInterface appUserInterface = new AppUserInterface(specialtyView, professionalView, patientView, appointmentView);
        appUserInterface.startApp();
    }
}