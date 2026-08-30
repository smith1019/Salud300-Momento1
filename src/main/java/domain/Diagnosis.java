package domain;

import java.util.Scanner;

public class Diagnosis {
    public Scanner sc = new Scanner(System.in);

    // Atributes

    private int id;
    private Consultation consultation;
    private String diagnosisCode;

    // Constructores

    public Diagnosis() {

    }

    public Diagnosis(int id, Consultation consultation, String diagnosisCode) {
        this.id = id;
        this.consultation = consultation;
        this.diagnosisCode = diagnosisCode;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    // Methods

    public void create() {
        System.out.println("Ingrese el Id del diagnóstico");
        this.id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese los datos de la consulta");
        this.consultation = new Consultation();
        this.consultation.create();

        System.out.println("Ingrese el código del diagnóstico");
        this.diagnosisCode = sc.nextLine();
    }

    public void select() {
        System.out.println("Id diagnóstico: " + this.id + "\n" +
                "Código: " + this.diagnosisCode
        );
        this.consultation.select();
    }
}
