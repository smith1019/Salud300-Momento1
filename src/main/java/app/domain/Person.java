package app.domain;

public class Person {

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

    @Override
    public String toString() {
        return "Id: " + this.id + "\n" +
                "Identificación: " + this.identification + "\n" +
                "Nombre: " + this.name + "\n" +
                "Apellido: " + this.lastName;
    }
}