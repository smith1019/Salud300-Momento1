package app.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FormRuleValidator {

    static Scanner sc = new Scanner(System.in);

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static int validateInt(String prompt) {

        while (true) {
            try {
                System.out.println(prompt);
                int value = sc.nextInt();
                sc.nextLine();
                return value;

            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                sc.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }

    public static double validateDouble(String prompt) {

        while (true) {
            try {
                System.out.println(prompt);
                double value = sc.nextDouble();
                sc.nextLine();
                return value;

            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número decimal válido.");
                sc.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }

    public static String validateString(String prompt) {

        while (true) {
            System.out.println(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            } else {
                System.out.println("Error: Ingrese un valor de texto válido.");
            }
        }
    }

    public static LocalDate validateDate(String prompt) {

        while (true) {
            String text = validateString(prompt + " (yyyy-MM-dd)");
            try {
                return LocalDate.parse(text, DATE_FORMAT);
            } catch (DateTimeParseException e) {
                System.out.println("Error: Ingrese una fecha válida con el formato yyyy-MM-dd.");
            }
        }
    }

    public static LocalDateTime validateDateTime(String prompt) {

        while (true) {
            String text = validateString(prompt + " (yyyy-MM-dd HH:mm)");
            try {
                return LocalDateTime.parse(text, DATE_TIME_FORMAT);
            } catch (DateTimeParseException e) {
                System.out.println("Error: Ingrese una fecha y hora válidas con el formato yyyy-MM-dd HH:mm.");
            }
        }
    }
}