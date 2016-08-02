package com.imran.myecommerce;

import android.graphics.drawable.Drawable;

/**
 * Created by Imran on 8/3/2016.
 */
public class Product {

    public String title;
    public double price;
    public String description;
    public Drawable productImage;

    public Product(String title, double price, String description, Drawable productImage) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.productImage = productImage;

    }

}
