package domain;

import java.util.Scanner;

public class Person {
    public Scanner sc = new Scanner(System.in);

    // Atributes

    private int id;
    private String identification;
    private String name;
    private String lastName;

    // Constructores

    public Person() {

    }

    public Person(int id, String identification, String name, String lastName) {
        this.id = id;
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Methods

    public void create() {
        System.out.println("Ingrese el Id");
        this.id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese la identificación");
        this.identification = sc.nextLine();

        System.out.println("Ingrese el nombre");
        this.name = sc.nextLine();

        System.out.println("Ingrese el apellido");
        this.lastName = sc.nextLine();
    }

    public void select() {
        System.out.println("Id: " + this.id + "\n" +
                "Identificación: " + this.identification + "\n" +
                "Nombre: " + this.name + "\n" +
                "Apellido: " + this.lastName
        );
    }
}
