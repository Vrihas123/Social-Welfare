package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_sub_categories.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.view.NgoEndFragment;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.view.ItemActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_sub_categories.model.SubCategoryData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrihas on 17/3/18.
 */

public class SubCategoriesAdapter extends RecyclerView.Adapter<SubCategoriesAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    Context context;
    SharedPrefs sharedPrefs;
    private List<SubCategoryData> subCategoryData = new ArrayList<>();

    public SubCategoriesAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setSubCategoryList(List<SubCategoryData> subCategorydata) {
        this.subCategoryData = subCategorydata;
    }

    @Override
    public SubCategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.sub_category_items, parent, false);
        sharedPrefs = new SharedPrefs(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubCategoriesAdapter.ViewHolder holder, int position) {

        final SubCategoryData data = subCategoryData.get(position);
        holder.ngoName.setText(data.getName());
        holder.ngoLocation.setText(data.getLocation());
        holder.ngoContact.setText(data.getContact());
        holder.ngo_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefs.setNgo_id(data.getId());
                sharedPrefs.setNgo_name(data.getName());
                ((ItemActivity)context).addFragment(new NgoEndFragment(),"Details");
            }
        });


    }

    @Override
    public int getItemCount() {
        return subCategoryData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView ngoName,ngoLocation,ngoContact;
        LinearLayout ngo_layout;

        public ViewHolder(View itemView) {
            super(itemView);
            ngoName = (TextView) itemView.findViewById(R.id.ngo_name);
            ngoLocation = (TextView) itemView.findViewById(R.id.ngo_location);
            ngoContact = (TextView) itemView.findViewById(R.id.ngo_contact);
            ngo_layout = (LinearLayout) itemView.findViewById(R.id.ngo_detail_layout);
        }
    }
}
