package domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    public void create() {
        super.create();

        System.out.println("Ingrese el género: 1. Masculino 2. Femenino 3. Otro");
        int option = sc.nextInt();
        sc.nextLine();
        this.gender = defineGender(option);

        System.out.println("Ingrese la fecha de nacimiento (yyyy-MM-dd)");
        String date = sc.nextLine();
        this.dateOfBirth = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println("Ingrese el teléfono");
        this.phone = sc.nextLine();
    }

    @Override
    public void select() {
        super.select();

        System.out.println("Género: " + this.gender + "\n" +
                "Fecha de nacimiento: " + this.dateOfBirth + "\n" +
                "Teléfono: " + this.phone
        );
    }

    // Helpers

    private Gender defineGender(int option) {
        switch (option) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                return Gender.OTHER;
        }
    }
}
