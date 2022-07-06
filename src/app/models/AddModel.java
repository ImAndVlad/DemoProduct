package app.models;

import app.database.ProductDataBase;
import app.views.ProductView;

public class AddModel {

    ProductDataBase dataBase;
    ProductView view;

    public void addProduct() {
        dataBase.list.add(view.getProduct());
    }
}
