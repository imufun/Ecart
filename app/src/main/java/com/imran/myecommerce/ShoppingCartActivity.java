package com.imran.myecommerce;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Imran on 8/3/2016.
 */
public class ShoppingCartActivity extends Activity {
    private List<Product> mProductList;
    private ProductAdapter mProductAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppingcart);

        mProductList = ShoppingCartHelper.getCart();
        for (int i = 0; i < mProductList.size(); i++) {
            mProductList.get(i).selected = false;
        }

// Create the list
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter = new ProductAdapter(mProductList, getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductAdapter);

        listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Product selectedProduct = mProductList.get(position);
                if (selectedProduct.selected == true)
                    selectedProduct.selected = false;
                else
                    selectedProduct.selected = true;

                mProductAdapter.notifyDataSetInvalidated();

            }
        });

        Button removeButton = (Button) findViewById(R.id.ButtonRemoveFromCart);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Loop through and remove all the products that are selected
                // Loop backwards so that the remove works correctly
                for (int i = mProductList.size() - 1; i >= 0; i--) {

                    if (mProductList.get(i).selected) {
                        mProductList.remove(i);
                    }
                }
                mProductAdapter.notifyDataSetChanged();
            }
        });
    }
}
