package app.views;

import app.base.Add;
import app.base.Delete;
import app.base.Read;
import app.base.Update;
import app.models.ProductModel;
import app.models.ProductPriceModel;
import app.utils.OptionMapValidator;
import app.utils.OptionValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProductView implements Add, Delete, Read, Update {

    Scanner scanner;
    ProductModel model;
    ProductPriceModel product;
    ArrayList<ProductModel> list;
    public HashMap<Double, ProductPriceModel> map;
    int size;
    int index;
    double price;

    public void options(int choice) {
        switch (choice) {
            case 1 -> readProduct();
            case 2 -> addProduct(getProduct());
            case 3 -> deleteProduct();
            case 4 -> updateProduct();
            case 5 -> optionsMap(getOptionMap());
            case 0 -> System.exit(0);
        }
    }

    public int getOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                --------------------------------
                Choose an option:
                1 - get product list
                2 - add product
                3 - delete product
                4 - product replacement
                5 - get HashMap
                                
                0 - close the application
                --------------------------------
                Enter:\040""");

        return OptionValidator.validatorOptionsInputs(scanner);
    }

    public void optionsMap(int choice) {
        switch (choice) {
            case 1 -> readMap();
            case 2 -> addMap();
            case 3 -> options(getOption());
            case 0 -> System.exit(0);
        }
    }

    public int getOptionMap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                --------------------------------
                Choose an option:
                1 - get map info
                2 - add product price
                3 - main menu
                                
                0 - close the application
                --------------------------------
                Enter:\040""");

        return OptionMapValidator.validatorOptionsMapInputs(scanner);
    }

    public ProductModel getProduct() {
        model = new ProductModel();
        scanner = new Scanner(System.in);

        System.out.println("Enter product name: ");
        model.name = scanner.nextLine();

        return model;
    }

    @Override
    public void addProduct(ProductModel product) {
        list.add(product);
        System.out.println("---product add---");

        size++;
        options(getOption());
    }

    @Override
    public void readProduct() {
        if (list.isEmpty())
            System.out.println("List is empty");
        else System.out.println("---PRODUCT INFO---\n" +
                list + "\nSize: " + list.size());

        options(getOption());
    }

    @Override
    public void deleteProduct() {
        list.remove(getIndex());
        System.out.println("---product remove---");

        size--;

        options(getOption());
    }

    @Override
    public void updateProduct() {
        list.set(getIndex(), getProduct());
        System.out.println("---List update---");

        options(getOption());
    }

    private int getIndex() {
        scanner = new Scanner(System.in);

        if (size == 0) {
            System.out.println("List is empty");
            options(getOption());
        } else {
            System.out.println("Enter number (1 - " + size + "): ");
            index = scanner.nextInt();
            index--;
        }
        return index;
    }

    @Override
    public void addMap() {
        scanner = new Scanner(System.in);

        System.out.println(list);

        System.out.println("Enter price(for element " + (getIndex() + 1) + "): ");
        price = scanner.nextDouble();

        product = new ProductPriceModel(list.get(index), price);
        map.put(price, product);

        System.out.println("---info add---");

        optionsMap(getOptionMap());
    }

    @Override
    public void readMap() {
        System.out.println("---Map info---");
        if (map.isEmpty())
            System.out.println("list is empty");
        else
            System.out.println(map + "\nSize: " + map.size());

        optionsMap(getOptionMap());
    }

    public void start() {
        list = new ArrayList<>();
        map = new HashMap<>();
        options(getOption());
    }
}
