package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.HomeActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.model.ItemData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.presenter.ItemPresenter;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.presenter.ItemPresenterImpl;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.provider.RetrofitItemProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemActivity extends AppCompatActivity
        implements ItemView {

    @BindView(R.id.item_recycler)
    RecyclerView itemRecycler;

    private SharedPrefs sharedPrefs;
    private ItemAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    private ItemPresenter itemPresenter;

    @BindView(R.id.progressBar_item)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);
        sharedPrefs = new SharedPrefs(this);
        itemRecycler.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        itemRecycler.setLayoutManager(linearLayoutManager);
        adapter = new ItemAdapter(this);
        itemRecycler.setAdapter(adapter);
        itemRecycler.setNestedScrollingEnabled(false);

        itemPresenter = new ItemPresenterImpl(this,new RetrofitItemProvider());
        itemPresenter.requesItem(sharedPrefs.getAccessToken());

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        setSupportActionBar(toolbar);*/

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ItemActivity.this, HomeActivity.class);
        startActivity(i);
        finish();
    }





    /*public void setFragment(Fragment fragment) {

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
        }

    }

    public void addFragment(Fragment fragment, String title) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }

    }*/

    @Override
    public void setData(List<ItemData> itemDataList) {
        adapter.setItemDataList(itemDataList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showProgressBar(boolean show) {

        if(show){
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
