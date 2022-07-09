package app.models;

public class ProductPriceModel {

    ProductModel name;
    double price;

    public ProductPriceModel(ProductModel name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "price" + name;
    }
}
