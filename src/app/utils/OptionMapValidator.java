package app.utils;

import java.util.Scanner;

public class OptionMapValidator {

    public static int validatorOptionsMapInputs(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf("\"%s\" - not a number!\n", str);
            System.out.print("Enter number 0-4\n");
        }
        int choice = scanner.nextInt();
        while (choice < 0 || choice > 3) {
            System.out.println("Incorrect value\n" +
                    "Enter number 0-4\n");
            while (!scanner.hasNextInt()) {
                String str = scanner.next().trim();
                System.out.printf("\"%s\" - not a number!\n", str);
                System.out.print("Enter number 0-4\n");
            }
            choice = scanner.nextInt();
        }
        return choice;
    }
}
