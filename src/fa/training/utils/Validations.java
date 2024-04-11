package fa.training.utils;

import fa.training.Constants;
import fa.training.services.Implematations.*;
import fa.training.services.Interface.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validations {

    public static Scanner scanner = new Scanner(System.in);

    // The isbn is a unique numeric commercial book identifier.
    // The length of ‘isbn’ is in the 10-17 digit number and the ‘-‘ quote.
    // Ex: 678-3-16-1486.
    public static boolean isValidISBN(String isbn) {
        // Remove all non-numeric characters
        String cleanISBN = isbn.replaceAll("-", "");

        // Check if the length is between 10 and 17 digits
        if (cleanISBN.length() < 10 || cleanISBN.length() > 17) {
            return false;
        }

        // Check if all characters are digits
        for (char c : cleanISBN.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        // All conditions met, ISBN is valid
        return true;
    }

    // Check correct string date format (dd/MM/yyyy)
    public static boolean isValidDate(String birthDate) {
        String regex = Constants.REGEX_VALID_DATE_DDMMYYYY;
        return birthDate.matches(regex);
    }

    // Check correct Date (yyyy-MM-dd)
    public static Date inputValidDate(String prompt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
        while (true) {
            System.out.print(prompt);
            String inputDate = scanner.nextLine();
            try {
                if (inputDate.matches(Constants.REGEX_VALID_DATE_YYYYMMDD)) {
                    return dateFormat.parse(inputDate);
                } else {
                    System.out.println(Constants.INVALID_DATE_FORMAT_INPUT);
                }
            } catch (ParseException e) {
                System.out.println(Constants.INVALID_DATE_FORMAT_INPUT);
            }
        }
    }

    // Parse String to Date
    public static Date parseStringtoDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Check valid input int >= 0
    public static int inputInt(String prompt) {
        int value = 0;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println(Constants.INVALID_INT_INPUT);
                System.out.print(prompt);
                scanner.next(); // Consume the invalid input
            }
            value = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } while (value <= 0);
        return value;
    }

    // Check valid input int >= 0
    public static String inputLine(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextLine()) {
            System.out.println(Constants.INVALID_LINE_INPUT);
        }
        return scanner.nextLine();
    }
}
