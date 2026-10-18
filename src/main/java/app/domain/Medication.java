package domain;

import java.util.Scanner;

public class Medication {
    public Scanner sc = new Scanner(System.in);

    // Atributes

    private int id;
    private String name;
    private String dosis;
    private String manufacturer;

    // Constructores

    public Medication() {

    }

    public Medication(int id, String name, String dosis, String manufacturer) {
        this.id = id;
        this.name = name;
        this.dosis = dosis;
        this.manufacturer = manufacturer;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // Methods

    public void create() {
        System.out.println("Ingrese el Id del medicamento");
        this.id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el nombre del medicamento");
        this.name = sc.nextLine();

        System.out.println("Ingrese la dosis");
        this.dosis = sc.nextLine();

        System.out.println("Ingrese el fabricante");
        this.manufacturer = sc.nextLine();
    }

    public void select() {
        System.out.println("Id medicamento: " + this.id + "\n" +
                "Nombre: " + this.name + "\n" +
                "Dosis: " + this.dosis + "\n" +
                "Fabricante: " + this.manufacturer
        );
    }
}
