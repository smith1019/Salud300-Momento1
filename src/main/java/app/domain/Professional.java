package app.domain;

public class Professional extends Person {

    // Atributes

    private String licenseNumber;
    private String email;
    private Specialty specialty;

    // Constructores

    public Professional() {

    }

    public Professional(int id, String identification, String name, String lastName, String licenseNumber, String email, Specialty specialty) {
        super(id, identification, name, lastName);
        this.licenseNumber = licenseNumber;
        this.email = email;
        this.specialty = specialty;
    }

    // Getters and setters

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    // Methods

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Licencia: " + this.licenseNumber + "\n" +
                "Correo: " + this.email + "\n" +
                "Especialidad: " + (this.specialty != null ? this.specialty.getName() : null);
    }
}