package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.view.NgoEndFragment;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.view.ItemActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.view.PaymentActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.model.NgoPaymentData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrihas on 17/3/18.
 */

public class NgoPaymentAdapter extends RecyclerView.Adapter<NgoPaymentAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    Context context;
    SharedPrefs sharedPrefs;
    private List<NgoPaymentData> ngoPaymentData = new ArrayList<>();

    public NgoPaymentAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setSubCategoryList(List<NgoPaymentData> subCategorydata) {
        this.ngoPaymentData = subCategorydata;
    }

    @Override
    public NgoPaymentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.sub_category_items, parent, false);
        sharedPrefs = new SharedPrefs(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NgoPaymentAdapter.ViewHolder holder, int position) {

        final NgoPaymentData data = ngoPaymentData.get(position);
        holder.ngo_name.setText(data.getName());
        holder.relativeLayoutPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPrefs.setNgo_id(data.getId());
                Intent i = new Intent(context,PaymentActivity.class);
                context.startActivity(i);
            }
        });
//        holder.ngoName.setText(data.getName());
//        holder.ngoLocation.setText(data.getLocation());
//        holder.ngoContact.setText(data.getContact());
//        holder.ngo_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sharedPrefs.setNgo_id(data.getId());
//                sharedPrefs.setNgo_name(data.getName());
//                ((ItemActivity)context).addFragment(new NgoEndFragment(),"Details");
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return ngoPaymentData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ngo_name;
        public RelativeLayout relativeLayoutPayment;


        public ViewHolder(View itemView) {
            super(itemView);
            Context context;
            ngo_name = (TextView) itemView.findViewById(R.id.item_name_payment);
            relativeLayoutPayment = (RelativeLayout) itemView.findViewById(R.id.layout_item_payment);
        }
    }
}
