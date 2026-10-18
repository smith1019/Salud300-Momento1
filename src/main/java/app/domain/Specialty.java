package domain;

import java.util.Scanner;

public class Specialty {
    public Scanner sc = new Scanner(System.in);

    // Atributes

    private int id;
    private String name;

    // Constructores

    public Specialty() {

    }

    public Specialty(int id, String name) {
        this.id = id;
        this.name = name;
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

    // Methods

    public void create() {
        System.out.println("Ingrese el Id de la especialidad");
        this.id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el nombre de la especialidad");
        this.name = sc.nextLine();
    }

    public void select() {
        System.out.println("Id especialidad: " + this.id + "\n" +
                "Nombre: " + this.name
        );
    }
}
