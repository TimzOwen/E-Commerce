package com.owen.netmall.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.owen.netmall.Interface.ItemClickListner;
import com.owen.netmall.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

{

    public TextView tvProductName, tvProductDescription;
    public ImageView ivProductImage;
    public ItemClickListner listner;

    public ProductViewHolder(View itemView)
    {
        super(itemView);

        ivProductImage =  itemView.findViewById(R.id.item_product_image);
        tvProductName =  itemView.findViewById(R.id.item_product_name);
        tvProductDescription = itemView.findViewById(R.id.item_product_description);
    }

    public void setItemClickListner(ItemClickListner listner)
    {
        this.listner = listner;
    }

    @Override
    public void onClick(View view)
    {
        listner.onClick(view ,getAdapterPosition(), false);
    }
}
