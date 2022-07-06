package app.views;

import app.models.ProductModel;

import java.util.Scanner;

public class ProductView {

    Scanner scanner;
    ProductModel model;

    public int getOption() {
        scanner = new Scanner(System.in);
        System.out.println("""
                Choose an option:
                1 - get product list
                2 - add product
                3 - delete product
                4 - update list
                
                0 - close the application""");

        return scanner.nextInt();
    }

    public ProductModel getProduct() {
        scanner = new Scanner(System.in);

        System.out.println("Enter product name: ");
        model.setName(scanner.nextLine());

        return model;
    }
}
