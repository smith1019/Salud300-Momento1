package app.domain;

import java.time.LocalDate;

public class Patient extends Person {

    // Atributes

    private Gender gender;
    private LocalDate dateOfBirth;
    private String phone;

    // Constructores

    public Patient() {

    }

    public Patient(int id, String identification, String name, String lastName, Gender gender, LocalDate dateOfBirth, String phone) {
        super(id, identification, name, lastName);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
    }

    // Getters and setters

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Methods

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Género: " + this.gender + "\n" +
                "Fecha de nacimiento: " + this.dateOfBirth + "\n" +
                "Teléfono: " + this.phone;
    }
}