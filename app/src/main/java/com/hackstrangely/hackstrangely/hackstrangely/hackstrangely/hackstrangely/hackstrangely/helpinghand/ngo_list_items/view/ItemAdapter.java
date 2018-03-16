package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.view;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.model.ItemData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_sub_categories.view.SubProductsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private List<ItemData> itemDataList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    Context context;
    SharedPrefs sharedPrefs;

    public ItemAdapter(Context context){

        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    public void setItemDataList(List<ItemData> itemData){
        this.itemDataList = itemDataList;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.item_recycler_item,parent,false);
        sharedPrefs = new SharedPrefs(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final ItemData itemData1 = itemDataList.get(position);
        holder.itemName.setText(itemData1.getName());
        Glide.with(context).load(itemData1.getImage()).into(holder.itemImage);
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sharedPrefs.setItem_id(itemData1.getId());
                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_body, new SubProductsFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView itemName;
        public ImageView itemImage;
        RelativeLayout itemLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            itemLayout = (RelativeLayout) itemView.findViewById(R.id.layout_item);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemImage = (ImageView) itemView.findViewById(R.id.item_img);
        }
    }
}
