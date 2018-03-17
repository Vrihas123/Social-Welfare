package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.model.SubCategoryData;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by samveg on 26/8/17.
 */

public class SubCategoriesAdapter extends RecyclerView.Adapter<SubCategoriesAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    Context context;
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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubCategoriesAdapter.ViewHolder holder, int position) {

        SubCategoryData data = subCategoryData.get(position);


    }

    @Override
    public int getItemCount() {
        return subCategoryData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {



        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
