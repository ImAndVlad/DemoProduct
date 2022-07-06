package app.views;

import app.database.ProductDataBase;
import app.models.AddModel;
import app.models.ProductModel;
import app.utils.OptionValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductView {

    static Scanner scanner;
    static ProductModel model;
    public static ArrayList<ProductModel> list;
    static int size;
    static AddModel add;
    static ProductDataBase database;

    public static int getOption() {
        scanner = new Scanner(System.in);
        System.out.print("""
                --------------------------------
                Choose an option:
                1 - get product list
                2 - add product
                3 - delete product
                4 - product replacement
                                
                0 - close the application
                --------------------------------
                Enter:\040""");

        return OptionValidator.validatorOptionsInputs(scanner);
    }

    public static void options(int choice) {
        switch (choice) {
            case 1 -> read();
            case 2 -> database01();
            case 3 -> delete();
            case 4 -> update();
            case 0 -> System.exit(0);
        }
    }

    public static ProductModel getProduct() {
        model = new ProductModel();
        scanner = new Scanner(System.in);

        System.out.println("Enter product name: ");
        model.name = scanner.nextLine();

        return model;
    }

    public static void database01() {
        list.add(getProduct());
        System.out.println("---product add---");

        size++;
        options(getOption());
    }

    public static void read() {
        if (list.isEmpty())
            System.out.println("List is empty");
        else System.out.println("---PRODUCT INFO---\n" +
                list + "\nSize: " +  list.size());

        options(getOption());
    }

    public static void delete() {
        scanner = new Scanner(System.in);

        System.out.println("Enter number (1 - " + size + "): ");
        int index = scanner.nextInt();

        index--;
        list.remove(index);
        System.out.println("---product remove---");

        size--;

        options(getOption());
    }

    public static void update() {
        scanner = new Scanner(System.in);

        System.out.println("Enter number (1 - " + size + "): ");
        int index = scanner.nextInt();
        index--;

        list.set(index, getProduct());
        System.out.println("---List update---");

        options(getOption());
    }

    public static void main(String[] args) {
        list = new ArrayList<>();
        options(getOption());
    }
}
