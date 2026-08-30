package domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Treatment {
    public Scanner sc = new Scanner(System.in);

    // Atributes

    private int id;
    private Diagnosis diagnosis;
    private LocalDate initialDate;
    private LocalDate endDate;

    // Constructores

    public Treatment() {

    }

    public Treatment(int id, Diagnosis diagnosis, LocalDate initialDate, LocalDate endDate) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.initialDate = initialDate;
        this.endDate = endDate;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Methods

    public void create() {
        System.out.println("Ingrese el Id del tratamiento");
        this.id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese los datos del diagnóstico");
        this.diagnosis = new Diagnosis();
        this.diagnosis.create();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Ingrese la fecha inicial (yyyy-MM-dd)");
        this.initialDate = LocalDate.parse(sc.nextLine(), formatter);

        System.out.println("Ingrese la fecha final (yyyy-MM-dd) o deje vacío si sigue activo");
        String end = sc.nextLine();
        this.endDate = end.isEmpty() ? null : LocalDate.parse(end, formatter);
    }

    public void select() {
        System.out.println("Id tratamiento: " + this.id + "\n" +
                "Fecha inicial: " + this.initialDate + "\n" +
                "Fecha final: " + this.endDate
        );
        this.diagnosis.select();
    }
}
