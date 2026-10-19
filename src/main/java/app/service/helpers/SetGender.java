package app.service.helpers;

import app.domain.Gender;
import app.utils.FormRuleValidator;

public class SetGender {

    public static Gender getGender() {

        while (true) {
            int option = FormRuleValidator.validateInt("""
                    Seleccione el género:
                    1. Masculino
                    2. Femenino
                    3. Otro
                    """);

            switch (option) {
                case 1:
                    return Gender.MALE;
                case 2:
                    return Gender.FEMALE;
                case 3:
                    return Gender.OTHER;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}