/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */
package com.hms.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.function.Predicate;

public class Utility {
    private static final Scanner SCANNER = new Scanner(System.in);

    // Using varargs to accept any number of menu options - Feature 1.3: Varargs
    public static int displayMenu(String title, String... options) {
        System.out.println("\n" + title);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        int choice = -1;
        while (true) {
            System.out.print("Choose an option: ");
            try {
                choice = SCANNER.nextInt();
                if (choice >= 1 && choice <= options.length) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please select a number between 1 and " + options.length + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                SCANNER.next(); 
            }
        }
        SCANNER.nextLine(); 
        return choice;
    }


    public static String readString(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine();
    }


    public static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!SCANNER.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            SCANNER.next();
        }
        double value = SCANNER.nextDouble();
        SCANNER.nextLine(); 
        return value;
    }

    public static Integer readInt(String prompt) {
        System.out.print(prompt);
        while (!SCANNER.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            SCANNER.next();
        }
        Integer value = SCANNER.nextInt();
        SCANNER.nextLine(); 
        return value;
    }

    public static <T> boolean validateInput(T input, Predicate<T> validator, String errorMessage) {
        if (!validator.test(input)) {
            System.out.println(errorMessage);
            return false;
        }
        return true;
    }
}
