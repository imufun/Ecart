package com.imran.myecommerce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Imran on 8/3/2016.
 */
public class ProductAdapter extends BaseAdapter {

    private List<Product> mProductList;
    private LayoutInflater mInflater;
    private boolean mShowCheckBox;

    public ProductAdapter(List<Product> list, LayoutInflater layoutInflater, boolean showCheckBox) {
        this.mProductList = list;
        this.mInflater = layoutInflater;
        this.mShowCheckBox = showCheckBox;
    }


    @Override
    public int getCount() {
        return mProductList.size();

    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewItem item;
        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.item, null);

            item = new ViewItem();
            item.productImageView = (ImageView) convertView.findViewById(R.id.ImageViewItem);
            item.productTitle = (TextView) convertView.findViewById(R.id.TextViewItem);
            item.productCheckBox = (CheckBox) convertView.findViewById(R.id.CheckBoxSelected);

            convertView.setTag(item);
        } else {
            item = (ViewItem) convertView.getTag();
        }
        Product cutProduct = mProductList.get(position);
        item.productImageView.setImageDrawable(cutProduct.productImage);
        item.productTitle.setText(cutProduct.title);

        if (!mShowCheckBox){
            item.productCheckBox.setVisibility(View.GONE);
        }


        return null;
    }

    private class ViewItem {
        ImageView productImageView;
        TextView productTitle;
        CheckBox productCheckBox;
    }
}