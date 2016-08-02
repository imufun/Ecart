package com.imran.myecommerce;

import android.content.res.Resources;

import java.util.List;
import java.util.Vector;

/**
 * Created by Imran on 8/3/2016.
 */
public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";


    public static List<Product> catalog;
    public static List<Product> cart;


    public static List<Product> getCatalog(Resources res) {

        if (catalog == null) {
            catalog = new Vector<Product>();
            catalog.add(new Product("Yes or No", 20.20, "I love you!!!", res.getDrawable(R.mipmap.ic_launcher)));
            catalog.add(new Product("Yes", 10.50, "I hate you!!!", res.getDrawable(R.mipmap.ic_launcher)));
            catalog.add(new Product("No", 2.0, "I miss you!!!", res.getDrawable(R.mipmap.ic_launcher)));
        }
        return catalog;
    }

    public static List<Product> getCart() {
        if (cart == null) {
            cart = new Vector<Product>();
        }

        return cart;
    }
}
