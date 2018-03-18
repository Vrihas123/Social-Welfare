package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.model.NgoPaymentData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.presenter.NgoPaymentPresenter;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.presenter.NgoPaymentPresenterImpl;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.provider.RetrofitNgoPaymentProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NgoPaymentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NgoPaymentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NgoPaymentFragment extends Fragment implements NgoPaymentView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.sub_category_recycler)
    RecyclerView subCategoryRecycler;
    LinearLayoutManager linearLayoutManager;
    NgoPaymentAdapter adapter;

    @BindView(R.id.sub_category_progressBar)
    ProgressBar progressBar;

//    @BindView(R.id.sub_category_toolbar)
//    Toolbar subCategory_toolbar;

    private NgoPaymentPresenter ngoPaymentPresenter;
    private SharedPrefs sharedPrefs;

    public NgoPaymentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NgoPaymentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NgoPaymentFragment newInstance(String param1, String param2) {
        NgoPaymentFragment fragment = new NgoPaymentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_categories, container, false);
        ButterKnife.bind(this, view);

        //  subCategory_toolbar.setTitleTextColor(ContextCompat.getColor(getContext(), R.color.white));

        subCategoryRecycler.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext());
        subCategoryRecycler.setLayoutManager(linearLayoutManager);
        adapter = new NgoPaymentAdapter(getContext());
        subCategoryRecycler.setAdapter(adapter);
        subCategoryRecycler.setNestedScrollingEnabled(false);

        sharedPrefs = new SharedPrefs(getContext());
//        if (getActivity() instanceof HomeActivity) {
//
//            ((HomeActivity) getContext()).getSupportActionBar().hide();
//        }

        ngoPaymentPresenter = new NgoPaymentPresenterImpl(NgoPaymentFragment.this,new RetrofitNgoPaymentProvider());
        ngoPaymentPresenter.requestNgoPayment(sharedPrefs.getAccessToken());
        return view;
    }





    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProgressBar(boolean show) {
        if(show){
            progressBar.setVisibility(View.VISIBLE);
        }
        else
        {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void setSubCategoryData(List<NgoPaymentData> subCategoryList) {
        adapter.setSubCategoryList(subCategoryList);
        adapter.notifyDataSetChanged();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
