package domain;

import java.util.Scanner;

public class Allergy {
    public Scanner sc = new Scanner(System.in);

    // Atributes

    private int id;
    private String name;

    // Constructores

    public Allergy() {

    }

    public Allergy(int id, String name) {
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
        System.out.println("Ingrese el Id de la alergia");
        this.id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el nombre de la alergia");
        this.name = sc.nextLine();
    }

    public void select() {
        System.out.println("Id alergia: " + this.id + "\n" +
                "Nombre: " + this.name
        );
    }
}
