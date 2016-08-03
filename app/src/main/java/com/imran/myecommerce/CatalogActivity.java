package com.imran.myecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Imran on 8/3/2016.
 */
public class CatalogActivity extends AppCompatActivity {

    private List<Product> mProductList;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog);

        mProductList = ShoppingCartHelper.getCatalog(getResources());

        ListView ListViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        ListViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false));
        Button ButtonViewCart = (Button) findViewById(R.id.ButtonViewCart);


        ListViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(), ProductDetailsActivity.class);
                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });

        ButtonViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);
            }
        });


    }
}
