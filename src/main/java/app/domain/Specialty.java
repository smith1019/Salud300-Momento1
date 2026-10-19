package app.domain;

public class Specialty {

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

    @Override
    public String toString() {
        return "Id especialidad: " + this.id + "\n" +
                "Nombre: " + this.name;
    }
}