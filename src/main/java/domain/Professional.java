package domain;

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
    public void create() {
        super.create();

        System.out.println("Ingrese el número de licencia");
        this.licenseNumber = sc.nextLine();

        System.out.println("Ingrese el correo");
        this.email = sc.nextLine();

        System.out.println("Ingrese los datos de la especialidad");
        this.specialty = new Specialty();
        this.specialty.create();
    }

    @Override
    public void select() {
        super.select();

        System.out.println("Licencia: " + this.licenseNumber + "\n" +
                "Correo: " + this.email
        );
        this.specialty.select();
    }
}
