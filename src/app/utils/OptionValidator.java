package app.utils;

import java.util.Scanner;

public class OptionValidator {

    public static int validatorOptionsInputs(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf("\"%s\" - not a number!\n", str);
            System.out.print("Enter number 0-4\n");
        }
        int choice = scanner.nextInt();
        while (choice < 0 || choice > 4) {
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
